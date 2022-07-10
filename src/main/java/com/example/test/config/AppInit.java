package com.example.test.config;

import com.example.test.model.Purchase;
import com.example.test.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppInit {
    @Autowired
    private PurchaseService purchaseService;

    @Bean
    public Iterable<Purchase> init() {
        if (purchaseService.count() == null || purchaseService.count() == 0) {
            return purchaseService.createAll(List.of(
                    new Purchase("Телевизор"),
                    new Purchase("Смартфон"),
                    new Purchase("Соковыжималка"),
                    new Purchase("Наушники"),
                    new Purchase("Клавиатура")
            ));
        }
        return null;
    }
}
