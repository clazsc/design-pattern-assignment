package com.demo.strategy.strategies;

import com.demo.strategy.interfaces.DiscountStrategy;

public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculateDiscount(double originalPrice) {
        System.out.println("（应用策略：此书无折扣）");
        return originalPrice;
    }
}