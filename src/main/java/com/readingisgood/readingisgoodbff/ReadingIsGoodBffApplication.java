package com.readingisgood.readingisgoodbff;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableMongoAuditing
@OpenAPIDefinition
public class ReadingIsGoodBffApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadingIsGoodBffApplication.class, args);
    }



}
