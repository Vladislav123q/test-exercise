package com.example.test.repository;

import com.example.test.model.InfoPurchaseUser;
import com.example.test.model.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
    Purchase findByName(String name);
}
