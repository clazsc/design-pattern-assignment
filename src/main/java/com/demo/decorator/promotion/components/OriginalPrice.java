package com.demo.decorator.promotion.components;

/**
 * 原价策略 - 具体组件实现
 *
 * 装饰器模式中的ConcreteComponent角色，代表没有使用任何优惠券的原价状态
 * 这是装饰器模式的基础，所有优惠券都会在原价基础上进行折扣计算
 *
 * 设计模式角色：ConcreteComponent（具体组件）
 */
public class OriginalPrice implements IPromotionStrategy {
    @Override
    public double calculatePrice(double originalPrice) {
        return originalPrice;  // 原价，不做任何折扣
    }

    @Override
    public String getDescription() {
        return "原价";
    }

    @Override
    public double getDiscountAmount(double originalPrice) {
        return 0.0;  // 原价没有折扣
    }
}