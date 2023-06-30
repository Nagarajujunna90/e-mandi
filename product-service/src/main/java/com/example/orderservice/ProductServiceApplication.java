package com.example.orderservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {
   /* @Value("${key-test}")
    private String value;*/
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(@Value("${username}") String value) {
        return args->{
			System.out.println(value);
		};
    }
}
