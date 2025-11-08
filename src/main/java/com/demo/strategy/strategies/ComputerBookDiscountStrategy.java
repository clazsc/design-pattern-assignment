package com.demo.strategy.strategies;

import com.demo.strategy.interfaces.DiscountStrategy;

public class ComputerBookDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculateDiscount(double originalPrice) {
        System.out.println("（应用策略：计算机类图书打7折）");
        return originalPrice * 0.7;
    }
}