package com.demo.decorator.promotion.decorators;

import com.demo.decorator.promotion.components.IPromotionStrategy;

/**
 * 每满减券装饰器 - 具体装饰器实现
 *
 * 装饰器模式中的ConcreteDecorator角色，实现每满减优惠功能
 * 每满减券：每满足一定金额就减免固定金额，可以多次叠加
 * 例如：每满100减20，消费250元可以减2次20元共40元
 *
 * 设计模式角色：ConcreteDecorator（具体装饰器）
 *
 * 使用场景：阶梯式优惠，鼓励用户增加消费金额以获得更多优惠
 */
public class TieredFullReductionCoupon extends PromotionDecorator {
    private final double threshold;    // 每满的金额门槛
    private final double reduction;    // 每次减免的金额

    /**
     * 构造函数
     * @param strategy 被装饰的促销策略
     * @param threshold 每满的金额门槛
     * @param reduction 每次减免的金额
     */
    public TieredFullReductionCoupon(IPromotionStrategy strategy, double threshold, double reduction) {
        super(strategy);
        this.threshold = threshold;
        this.reduction = reduction;
    }

    /**
     * 计算每满减后的价格
     * 计算可以享受多少次每满减优惠，进行相应减免
     */
    @Override
    public double calculatePrice(double originalPrice) {
        double inputPrice = decoratedStrategy.calculatePrice(originalPrice);

        // 计算可以享受多少次每满减优惠
        int times = (int) (inputPrice / threshold);
        double totalReduction = times * reduction;

        return inputPrice - totalReduction;
    }

    /**
     * 获取完整的促销描述
     */
    @Override
    public String getDescription() {
        return decoratedStrategy.getDescription() + " + " + String.format("每满%.0f减%.0f", threshold, reduction);
    }

    /**
     * 获取总折扣金额
     */
    @Override
    public double getDiscountAmount(double originalPrice) {
        return originalPrice - calculatePrice(originalPrice);
    }
}