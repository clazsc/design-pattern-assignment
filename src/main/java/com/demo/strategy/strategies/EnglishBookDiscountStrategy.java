package com.demo.strategy.strategies;

import com.demo.strategy.interfaces.DiscountStrategy;

public class EnglishBookDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculateDiscount(double originalPrice) {
        System.out.println("（应用策略：英语类图书打6折）");
        return originalPrice * 0.6;
    }
}