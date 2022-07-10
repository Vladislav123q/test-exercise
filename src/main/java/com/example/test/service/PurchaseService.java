package com.example.test.service;

import com.example.test.model.Purchase;
import com.example.test.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public void createAll(List<Purchase> purchases){
        purchaseRepository.saveAll(purchases);
    }

    public Long count(){
        return purchaseRepository.count();
    }

    public Purchase findByName(String name){
        return purchaseRepository.findByName(name);
    }

    public List<Purchase> findAll(){
        return (List<Purchase>) purchaseRepository.findAll();
    }

}
