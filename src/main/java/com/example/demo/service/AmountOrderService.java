package com.example.demo.service;

public class AmountOrderService implements OrderService {
    final private int DISCOUNT_AMOUNT = 100;
    @Override
    public int getPrice(int price) {
        return price - DISCOUNT_AMOUNT;
    }
}
