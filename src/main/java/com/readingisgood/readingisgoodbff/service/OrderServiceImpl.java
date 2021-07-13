package com.readingisgood.readingisgoodbff.service;

import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodError;
import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.repository.OrderRepository;
import com.readingisgood.readingisgoodbff.repository.entity.Order;
import com.readingisgood.readingisgoodbff.service.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final BookService bookService;
    private final SequenceGeneratorService sequenceGeneratorService;


    @Override
    public void order(CreateOrderRequest request) throws ReadingIsGoodException {
        GetBookResponse getBookResponse = bookService.getBook(new GetBookRequest(request.getBookId()));
        if (request.getCount() > getBookResponse.getStock()) {
            throw new ReadingIsGoodException(ReadingIsGoodError.NOT_ENOUGH_STOCK_TO_ORDER);
        }

        int currentStock = getBookResponse.getStock() - request.getCount();
        UpdateStockRequest updateStockRequest = UpdateStockRequest.builder()
                .bookId(request.getBookId())
                .stock(currentStock)
                .build();
        bookService.updateStock(updateStockRequest);

        BigDecimal amount = getBookResponse.getPrice().multiply(new BigDecimal(request.getCount()));
        Order order = Order.builder()
                .id(sequenceGeneratorService.generateSequence(Order.SEQUENCE_NAME))
                .customerId(request.getCustomerId())
                .bookId(request.getBookId())
                .count(request.getCount())
                .amount(amount)
                .build();
        orderRepository.save(order);
    }

    @Override
    public GetOrderResponse getOrder(GetOrderRequest request) {
        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new ReadingIsGoodException(ReadingIsGoodError.ORDER_IS_INVALID));

        GetBookResponse getBookResponse = bookService.getBook(new GetBookRequest(order.getBookId()));

        return new GetOrderResponse(new OrderDTO(getBookResponse.getName(), order.getCount(), order.getUpdatedAt()));
    }

    @Override
    public GetCustomerOrderListResponse getCustomerOrderList(GetCustomerOrderListRequest request) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        List<Order> orderList = orderRepository.findOrdersByCustomerId(request.getCustomerId()).orElse(new ArrayList<>());
        for (Order order : orderList) {
            GetBookResponse getBookResponse = bookService.getBook(new GetBookRequest(order.getBookId()));
            orderDTOList.add(new OrderDTO(getBookResponse.getName(), order.getCount(), order.getUpdatedAt()));
        }
        return new GetCustomerOrderListResponse(orderDTOList);
    }

    @Override
    public GetOrderListResponse getOrderList(GetOrderListRequest request) {
        GetOrderListResponse response = new GetOrderListResponse();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date startDate = formatter.parse(request.getStartDate());
            Date endDate = formatter.parse(request.getEndDate());
            Optional<List<Order>> orderList = orderRepository.findOrdersByUpdatedAtBetween(startDate, endDate);
            if (orderList.isPresent()) {
                List<OrderDTO> orderDTOList = new ArrayList<>();
                for (Order order : orderList.get()) {
                    GetBookResponse getBookResponse = bookService.getBook(new GetBookRequest(order.getBookId()));
                    orderDTOList.add(new OrderDTO(getBookResponse.getName(), order.getCount(), order.getUpdatedAt()));
                }
                response.setOrderList(orderDTOList);
            }
        } catch (ParseException e) {
            throw new ReadingIsGoodException(ReadingIsGoodError.ORDER_LIST_DATE_INVALID);
        }
        return response;
    }
}
