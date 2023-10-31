package com.example.demo.service;

import org.springframework.stereotype.Service;

//@Service //서비스는 하나만 가능
public class RateOrderService implements OrderService {
    private final int DISCOUNT_RATE = 10;

    @Override
    public int getPrice(int price) {
        return price - ( price * DISCOUNT_RATE / 100 );
    }
}
