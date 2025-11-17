package com.demo.decorator.promotion.decorators;

import com.demo.decorator.promotion.components.IPromotionStrategy;

/**
 * 折扣券装饰器 - 具体装饰器实现
 *
 * 装饰器模式中的ConcreteDecorator角色，实现折扣优惠功能
 * 折扣券：按照一定比例进行折扣，如8折、7.5折等
 * 通常表示为小数形式，如0.8表示8折，0.7表示7折
 *
 * 设计模式角色：ConcreteDecorator（具体装饰器）
 *
 * 使用场景：会员等级折扣、品类折扣、活动折扣等
 */
public class DiscountCoupon extends PromotionDecorator {
    private final double discountRate;  // 折扣率 (0.1-1.0)

    /**
     * 构造函数
     * @param strategy 被装饰的促销策略
     * @param discountRate 折扣率，如0.8表示8折
     */
    public DiscountCoupon(IPromotionStrategy strategy, double discountRate) {
        super(strategy);
        if (discountRate < 0.1 || discountRate > 1.0) {
            throw new IllegalArgumentException("折扣率必须在0.1到1.0之间");
        }
        this.discountRate = discountRate;
    }

    /**
     * 计算折扣后的价格
     * 在上层处理后的价格基础上进行折扣计算
     */
    @Override
    public double calculatePrice(double originalPrice) {
        double inputPrice = decoratedStrategy.calculatePrice(originalPrice);
        return inputPrice * discountRate;
    }

    /**
     * 获取完整的促销描述
     */
    @Override
    public String getDescription() {
        return decoratedStrategy.getDescription() + " + " + String.format("%.1f折", discountRate * 10);
    }

    /**
     * 获取总折扣金额
     */
    @Override
    public double getDiscountAmount(double originalPrice) {
        return originalPrice - calculatePrice(originalPrice);
    }
}