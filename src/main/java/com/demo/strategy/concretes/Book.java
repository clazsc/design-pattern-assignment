package com.demo.strategy.concretes;

import com.demo.strategy.interfaces.DiscountStrategy;
import lombok.Data;

@Data
public class Book {
    private String title;
    private double originalPrice;
    private DiscountStrategy discountStrategy;

    public Book(String title, double originalPrice, DiscountStrategy strategy) {
        this.title = title;
        this.originalPrice = originalPrice;
        this.discountStrategy = strategy;
    }

    public double getFinalPrice() {
        return discountStrategy.calculateDiscount(this.originalPrice);
    }
}