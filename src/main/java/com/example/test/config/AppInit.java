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
                    new InfoPurchaseUser("Rostik", "Ivanov", 18, purchaseT, 5, 145.2, new Date(1657414835862L)),
                    new InfoPurchaseUser("Evgeni", "Koslov", 20, purchaseS, 10, 86.3, new Date(1655555555555L)),
                    new InfoPurchaseUser("Dima","Karpov",30,purchaseSok,2,500,new Date(16573448358624L)),
                    new InfoPurchaseUser("Andrei", "Andreev", 26, purchaseN, 1, 300, new Date(1657244835862L)),
                    new InfoPurchaseUser("Evgeni", "Evgiev", 18, purchaseT, 5, 200, new Date(1657144835862L)),
                    new InfoPurchaseUser("Anton", "Antonov", 18, purchaseS, 7, 800, new Date(99999)),
                    new InfoPurchaseUser("Maria", "Petrova", 31, purchaseS, 8, 7777, new Date(12349)),
                    new InfoPurchaseUser("Svetlana", "Babkina", 26, purchaseS, 2, 843, new Date(12389)),
                    new InfoPurchaseUser("Murad", "Muradov", 22, purchaseK, 3, 811, new Date(77777)),
                    new InfoPurchaseUser("Viktor", "Makin", 24, purchaseS, 4, 89, new Date(1239)),
                    new InfoPurchaseUser("Evgeni", "Kinash", 18, purchaseK, 6, 44, new Date(12349)),
                    new InfoPurchaseUser("Rostik", "Ivanov", 18, purchaseT, 5, 145.2, new Date(767676438)),
                    new InfoPurchaseUser("Evgeni", "Koslov", 20, purchaseS, 10, 86.3, new Date(123)),
                    new InfoPurchaseUser("Dima","Karpov",30,purchaseSok,2,500,new Date(900)),
                    new InfoPurchaseUser("Andrei", "Andreev", 26, purchaseN, 1, 300, new Date(999999999)),
                    new InfoPurchaseUser("Evgeni", "Evgiev", 18, purchaseT, 5, 200, new Date(99999)),
                    new InfoPurchaseUser("Anton", "Antonov", 18, purchaseS, 7, 800, new Date(99999)),
                    new InfoPurchaseUser("Maria", "Petrova", 31, purchaseS, 8, 7777, new Date(12349)),
                    new InfoPurchaseUser("Svetlana", "Babkina", 26, purchaseS, 2, 843, new Date(12389)),
                    new InfoPurchaseUser("Murad", "Muradov", 22, purchaseK, 3, 811, new Date(77777)),
                    new InfoPurchaseUser("Viktor", "Makin", 24, purchaseS, 4, 89, new Date(1239)),
                    new InfoPurchaseUser("Evgeni", "Kinash", 18, purchaseK, 6, 44, new Date(12349)),
                    new InfoPurchaseUser("Rostik", "Ivanov", 18, purchaseT, 5, 145.2, new Date(767676438)),
                    new InfoPurchaseUser("Evgeni", "Koslov", 20, purchaseS, 10, 86.3, new Date(123)),
                    new InfoPurchaseUser("Dima","Karpov",30,purchaseSok,2,500,new Date(900)),
                    new InfoPurchaseUser("Andrei", "Andreev", 26, purchaseN, 1, 300, new Date(999999999)),
                    new InfoPurchaseUser("Evgeni", "Evgiev", 18, purchaseT, 5, 200, new Date(99999)),
                    new InfoPurchaseUser("Anton", "Antonov", 18, purchaseS, 7, 800, new Date(99999)),
                    new InfoPurchaseUser("Maria", "Petrova", 31, purchaseS, 8, 7777, new Date(12349)),
                    new InfoPurchaseUser("Svetlana", "Babkina", 26, purchaseS, 2, 843, new Date(12389)),
                    new InfoPurchaseUser("Murad", "Muradov", 22, purchaseK, 3, 811, new Date(77777)),
                    new InfoPurchaseUser("Viktor", "Makin", 24, purchaseS, 4, 89, new Date(1239)),
                    new InfoPurchaseUser("Evgeni", "Kinash", 18, purchaseK, 6, 44, new Date(12349)),
                    new InfoPurchaseUser("Rostik", "Ivanov", 18, purchaseT, 5, 145.2, new Date(767676438)),
                    new InfoPurchaseUser("Evgeni", "Koslov", 20, purchaseS, 10, 86.3, new Date(123)),
                    new InfoPurchaseUser("Dima","Karpov",30,purchaseSok,2,500,new Date(900)),
                    new InfoPurchaseUser("Andrei", "Andreev", 26, purchaseN, 1, 300, new Date(999999999)),
                    new InfoPurchaseUser("Evgeni", "Evgiev", 18, purchaseT, 5, 200, new Date(99999)),
                    new InfoPurchaseUser("Anton", "Antonov", 18, purchaseS, 7, 800, new Date(99999)),
                    new InfoPurchaseUser("Maria", "Petrova", 31, purchaseS, 8, 7777, new Date(12349)),
                    new InfoPurchaseUser("Svetlana", "Babkina", 26, purchaseS, 2, 843, new Date(12389)),
                    new InfoPurchaseUser("Murad", "Muradov", 22, purchaseK, 3, 811, new Date(77777)),
                    new InfoPurchaseUser("Viktor", "Makin", 24, purchaseS, 4, 89, new Date(1657414835862L)),
                    new InfoPurchaseUser("Evgeni", "Kinash", 18, purchaseK, 6, 44, new Date(1657450835862L))
            ));
        }
    }
}
