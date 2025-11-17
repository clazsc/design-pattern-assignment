package com.demo.decorator.promotion.decorators;

import com.demo.decorator.promotion.components.IPromotionStrategy;

/**
 * 满减券装饰器 - 具体装饰器实现
 *
 * 装饰器模式中的ConcreteDecorator角色，实现满减优惠功能
 * 满减券：消费金额达到一定门槛后，可以减免固定金额
 * 例如：满200减30，满500减80
 *
 * 设计模式角色：ConcreteDecorator（具体装饰器）
 *
 * 使用场景：电商平台的满减活动，如"双11"、"618"等大促活动
 */
public class FullReductionCoupon extends PromotionDecorator {
    private final double threshold;    // 满减门槛
    private final double reduction;    // 减免金额

    /**
     * 构造函数
     * @param strategy 被装饰的促销策略
     * @param threshold 满减门槛（消费金额需要达到的最低数额）
     * @param reduction 减免金额
     */
    public FullReductionCoupon(IPromotionStrategy strategy, double threshold, double reduction) {
        super(strategy);
        this.threshold = threshold;
        this.reduction = reduction;
    }

    /**
     * 计算满减后的价格
     * 在上层处理后的价格基础上，检查是否满足满减条件，进行相应减免
     */
    @Override
    public double calculatePrice(double originalPrice) {
        double inputPrice = decoratedStrategy.calculatePrice(originalPrice);

        // 检查是否满足满减条件
        if (inputPrice >= threshold) {
            return inputPrice - reduction;
        } else {
            return inputPrice;
        }
    }

    /**
     * 获取完整的促销描述
     */
    @Override
    public String getDescription() {
        return decoratedStrategy.getDescription() + " + " + String.format("满%.0f减%.0f", threshold, reduction);
    }

    /**
     * 获取总折扣金额
     */
    @Override
    public double getDiscountAmount(double originalPrice) {
        return originalPrice - calculatePrice(originalPrice);
    }
}