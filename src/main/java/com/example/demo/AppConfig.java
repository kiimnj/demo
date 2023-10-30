package com.example.demo;

import com.example.demo.service.AmountOrderService;
import com.example.demo.service.OrderService;
import com.example.demo.service.RateOrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Service 위치 변경 대신 여기서 의존성 주입 - ocp 원칙도 지킬 수 ㅇ
@Configuration
public class AppConfig {
    @Bean
    public OrderService orderService() {
//        return new AmountOrderService();
        return new RateOrderService();
    }
}