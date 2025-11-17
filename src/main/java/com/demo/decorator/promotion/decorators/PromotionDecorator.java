package com.demo.decorator.promotion.decorators;

import com.demo.decorator.promotion.components.IPromotionStrategy;

/**
 * 促销装饰器抽象类 - 装饰器模式的核心
 *
 * 装饰器模式中的Decorator角色，实现了IPromotionStrategy接口并持有一个IPromotionStrategy的引用
 * 这是所有具体优惠券装饰器的基类，负责将被装饰策略与当前装饰器的功能进行组合
 *
 * 设计模式角色：Decorator（装饰器基类）
 *
 * 装饰器模式的关键特征：
 * 1. 实现与组件相同的接口（IPromotionStrategy）
 * 2. 持有一个策略对象的引用
 * 3. 组合被装饰策略的功能与当前装饰器的功能
 * 4. 通过抽象方法让子类实现自己的装饰逻辑
 */
public abstract class PromotionDecorator implements IPromotionStrategy {
    /**
     * 被装饰的促销策略对象
     * 这是装饰器模式的核心：装饰器持有一个策略的引用
     */
    protected IPromotionStrategy decoratedStrategy;

    /**
     * 构造函数，传入要被装饰的促销策略
     * @param strategy 要被装饰的促销策略
     */
    public PromotionDecorator(IPromotionStrategy strategy) {
        this.decoratedStrategy = strategy;
    }
}