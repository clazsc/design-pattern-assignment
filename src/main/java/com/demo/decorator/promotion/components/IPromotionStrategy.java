package com.demo.decorator.promotion.components;

/**
 * 促销策略接口 - 装饰器模式的核心组件接口
 *
 * 在电商系统中，商品价格可以通过多种促销策略进行调整
 * 这个接口定义了价格计算的基本行为，所有促销策略都需要实现
 *
 * 设计模式角色：Component（组件接口）
 *
 * 业务场景：商品价格计算，支持多种促销方式的叠加使用
 */
public interface IPromotionStrategy {

    /**
     * 计算最终价格
     * @param originalPrice 原始价格
     * @return 经过促销策略计算后的最终价格
     */
    double calculatePrice(double originalPrice);

    /**
     * 获取促销描述信息
     * @return 促销策略的描述文本
     */
    String getDescription();

    /**
     * 获取折扣金额
     * @param originalPrice 原始价格
     * @return 相对于原价的折扣金额
     */
    default double getDiscountAmount(double originalPrice) {
        return originalPrice - calculatePrice(originalPrice);
    }
}