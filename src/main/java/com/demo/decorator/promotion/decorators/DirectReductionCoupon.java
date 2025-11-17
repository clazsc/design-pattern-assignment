package com.demo.decorator.promotion.decorators;

import com.demo.decorator.promotion.components.IPromotionStrategy;

/**
 * 无条件减券装饰器 - 具体装饰器实现
 *
 * 装饰器模式中的ConcreteDecorator角色，实现无条件减免功能
 * 无条件减券：直接减免固定金额，不需要任何门槛条件
 * 例如：直接减10元，无最低消费要求
 *
 * 设计模式角色：ConcreteDecorator（具体装饰器）
 *
 * 使用场景：新用户券、节日券、补偿券等直接抵扣的优惠券
 */
public class DirectReductionCoupon extends PromotionDecorator {
    private final double reduction;    // 直接减免金额

    /**
     * 构造函数
     * @param strategy 被装饰的促销策略
     * @param reduction 直接减免的金额
     */
    public DirectReductionCoupon(IPromotionStrategy strategy, double reduction) {
        super(strategy);
        if (reduction < 0) {
            throw new IllegalArgumentException("减免金额不能为负数");
        }
        this.reduction = reduction;
    }

    /**
     * 计算直接减免后的价格
     * 在上层处理后的价格基础上直接减免固定金额，但确保价格不为负数
     */
    @Override
    public double calculatePrice(double originalPrice) {
        double inputPrice = decoratedStrategy.calculatePrice(originalPrice);
        return Math.max(0, inputPrice - reduction);
    }

    /**
     * 获取完整的促销描述
     */
    @Override
    public String getDescription() {
        return decoratedStrategy.getDescription() + " + " + String.format("直接减%.2f元", reduction);
    }

    /**
     * 获取总折扣金额
     */
    @Override
    public double getDiscountAmount(double originalPrice) {
        return originalPrice - calculatePrice(originalPrice);
    }
}