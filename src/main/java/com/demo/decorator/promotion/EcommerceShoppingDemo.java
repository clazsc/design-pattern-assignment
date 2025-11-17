package com.demo.decorator.promotion;

import com.demo.decorator.promotion.components.IPromotionStrategy;
import com.demo.decorator.promotion.components.OriginalPrice;
import com.demo.decorator.promotion.decorators.DirectReductionCoupon;
import com.demo.decorator.promotion.decorators.DiscountCoupon;
import com.demo.decorator.promotion.decorators.FullReductionCoupon;
import com.demo.decorator.promotion.decorators.TieredFullReductionCoupon;

/**
 * 电商购物演示客户端 - 优惠券装饰器模式演示程序
 *
 * 演示电商系统中如何使用装饰器模式实现多种优惠券的叠加使用
 * 展示了装饰器模式在真实业务场景中的强大应用价值
 *
 * 装饰器模式在优惠券系统中的优势：
 * 1. 优惠券可以任意叠加组合使用
 * 2. 新增优惠券类型不需要修改现有代码
 * 3. 计算顺序可以灵活调整（影响最终价格）
 * 4. 符合开闭原则，易于扩展
 */
public class EcommerceShoppingDemo {
    public static void main(String[] args) {
        System.out.println("=== 电商购物优惠券装饰器模式演示 ===\n");

        // 测试场景：原价299元的商品
        double originalPrice = 299.0;
        System.out.printf("商品原价：%.2f元\n\n", originalPrice);

        // 演示1：单独使用各种优惠券
        System.out.println("--- 场景1：单独使用各种优惠券 ---");
        testSingleCoupons(originalPrice);

        // 演示2：优惠券叠加使用（不同顺序）
        System.out.println("\n--- 场景2：优惠券叠加使用 ---");
        testCouponStacking(originalPrice);

        // 演示3：复杂优惠券组合
        System.out.println("\n--- 场景3：复杂优惠券组合 ---");
        testComplexCombination(originalPrice);

        System.out.println("\n=== 优惠券装饰器模式总结 ===");
        System.out.println("✓ 优惠券可以任意叠加组合");
        System.out.println("✓ 计算顺序影响最终价格");
        System.out.println("✓ 符合开闭原则，易于扩展新券种");
        System.out.println("✓ 避免了组合爆炸问题");
    }

    /**
     * 测试单独使用各种优惠券的效果
     */
    private static void testSingleCoupons(double originalPrice) {
        // 原价
        IPromotionStrategy original = new OriginalPrice();
        System.out.println("1. 原价策略：");
        printResult(original, originalPrice);

        // 满减券：满200减30
        IPromotionStrategy fullReduction = new FullReductionCoupon(original, 200, 30);
        System.out.println("\n2. 满减券（满200减30）：");
        printResult(fullReduction, originalPrice);

        // 折扣券：8.5折
        IPromotionStrategy discount = new DiscountCoupon(original, 0.85);
        System.out.println("\n3. 折扣券（8.5折）：");
        printResult(discount, originalPrice);

        // 每满减券：每满100减20
        IPromotionStrategy tiered = new TieredFullReductionCoupon(original, 100, 20);
        System.out.println("\n4. 每满减券（每满100减20）：");
        printResult(tiered, originalPrice);

        // 无条件减券：直接减15元
        IPromotionStrategy direct = new DirectReductionCoupon(original, 15);
        System.out.println("\n5. 无条件减券（直接减15元）：");
        printResult(direct, originalPrice);
    }

    /**
     * 测试优惠券叠加使用的不同顺序效果
     */
    private static void testCouponStacking(double originalPrice) {
        IPromotionStrategy base = new OriginalPrice();

        // 方案1：先折扣，后满减
        System.out.println("方案1：先折扣(8.5折) + 后满减(满200减30)");
        IPromotionStrategy plan1 = new FullReductionCoupon(
            new DiscountCoupon(base, 0.85), 200, 30);
        printResult(plan1, originalPrice);

        // 方案2：先满减，后折扣
        System.out.println("\n方案2：先满减(满200减30) + 后折扣(8.5折)");
        IPromotionStrategy plan2 = new DiscountCoupon(
            new FullReductionCoupon(base, 200, 30), 0.85);
        printResult(plan2, originalPrice);

        // 方案3：先每满减，后直接减
        System.out.println("\n方案3：先每满减(每满100减20) + 后直接减(15元)");
        IPromotionStrategy plan3 = new DirectReductionCoupon(
            new TieredFullReductionCoupon(base, 100, 20), 15);
        printResult(plan3, originalPrice);
    }

    /**
     * 测试复杂优惠券组合
     */
    private static void testComplexCombination(double originalPrice) {
        IPromotionStrategy base = new OriginalPrice();

        // 复杂组合：先折扣 + 再每满减 + 再满减 + 最后直接减
        System.out.println("复杂组合：折扣(8折) → 每满减(每满100减15) → 满减(满150减25) → 直接减(10元)");
        IPromotionStrategy complex = new DirectReductionCoupon(
            new FullReductionCoupon(
                new TieredFullReductionCoupon(
                    new DiscountCoupon(base, 0.8), 100, 15), 150, 25), 10);
        printResult(complex, originalPrice);
    }

    /**
     * 打印促销策略的计算结果
     */
    private static void printResult(IPromotionStrategy strategy, double originalPrice) {
        double finalPrice = strategy.calculatePrice(originalPrice);
        double discountAmount = strategy.getDiscountAmount(originalPrice);
        double discountRate = (discountAmount / originalPrice) * 100;

        System.out.println("  促销策略：" + strategy.getDescription());
        System.out.printf("  最终价格：%.2f元 | 总优惠：%.2f元 | 折扣率：%.1f%%\n",
                         finalPrice, discountAmount, discountRate);
    }
}