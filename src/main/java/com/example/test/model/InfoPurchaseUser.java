package com.example.test.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class InfoPurchaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;
    private int age;
    @OneToOne
    private Purchase purchaseItem;
    private int count;
    private double amount;
    private Date purchaseDate;

    public InfoPurchaseUser() {
    }

    public InfoPurchaseUser(String name, String lastname, int age, Purchase purchaseItem, int count, double amount, Date purchaseDate) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.purchaseItem = purchaseItem;
        this.count = count;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Purchase getPurchaseItem() {
        return purchaseItem;
    }

    public void setPurchaseItem(Purchase purchaseItem) {
        this.purchaseItem = purchaseItem;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
