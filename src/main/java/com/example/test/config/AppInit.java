package com.example.test.config;

import com.example.test.model.InfoPurchaseUser;
import com.example.test.model.Purchase;
import com.example.test.service.InfoPurchaseUserService;
import com.example.test.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class AppInit {
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private InfoPurchaseUserService infoPurchaseUserService;

    @Bean
    public void init() {
        if (purchaseService.findAll().isEmpty()) {
            purchaseService.createAll(List.of(
                    new Purchase("Телевизор"),
                    new Purchase("Смартфон"),
                    new Purchase("Соковыжималка"),
                    new Purchase("Наушники"),
                    new Purchase("Клавиатура")
            ));
        }
        if (infoPurchaseUserService.getAll().isEmpty()) {

            Purchase purchaseT = purchaseService.findByName("Телевизор");
            Purchase purchaseS = purchaseService.findByName("Смартфон");
            Purchase purchaseSok = purchaseService.findByName("Соковыжималка");
            Purchase purchaseN = purchaseService.findByName("Наушники");
            Purchase purchaseK = purchaseService.findByName("Клавиатура");

            infoPurchaseUserService.createAll(List.of(
                    new InfoPurchaseUser("Rostik", "Ivanov", 18, purchaseT, 5, 145.2, new Date(5000000)),
                    new InfoPurchaseUser("Evgeni", "Koslov", 20, purchaseS, 10, 86.3, new Date(123456789))
            ));
        }
    }
}
