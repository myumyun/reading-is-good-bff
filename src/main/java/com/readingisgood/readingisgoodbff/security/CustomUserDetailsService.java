package com.readingisgood.readingisgoodbff.security;

import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodError;
import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.repository.CustomerRepository;
import com.readingisgood.readingisgoodbff.repository.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Customer  is not found with email : " + email));
        return UserPrincipal.create(customer);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ReadingIsGoodException(ReadingIsGoodError.CUSTOMER_NOT_FOUND));
        return UserPrincipal.create(customer);
    }
}
