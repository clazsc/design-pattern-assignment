package com.demo.decorator.goatdemo.decorators;

import com.demo.decorator.goatdemo.components.IGoat;

/**
 * 羊装饰器抽象类 - 装饰器模式的核心
 *
 * 装饰器模式中的Decorator角色，实现了IGoat接口并持有一个IGoat的引用
 * 这是所有具体装饰器的基类，负责将请求转发给被装饰的对象
 *
 * 设计模式角色：Decorator（装饰器基类）
 *
 * 装饰器模式的关键特征：
 * 1. 实现与组件相同的接口（IGoat）
 * 2. 持有一个组件对象的引用
 * 3. 默认将所有方法调用转发给组件对象
 * 4. 子类可以重写方法来添加额外功能
 */
public abstract class DecoratedGoat implements IGoat {
    /**
     * 被装饰的羊对象
     * 这是装饰器模式的核心：装饰器持有一个组件的引用
     */
    protected IGoat decoratedGoat;

    /**
     * 构造函数，传入要被装饰的羊对象
     * @param goat 要被装饰的羊对象
     */
    public DecoratedGoat(IGoat goat) {
        this.decoratedGoat = goat;
    }

    /**
     * 逃跑方法 - 默认直接转发给被装饰的对象
     * 具体装饰器可以重写此方法来添加额外的逃跑效果
     */
    @Override
    public void flee() {
        decoratedGoat.flee();
    }

    /**
     * 失去生命方法 - 默认直接转发给被装饰的对象
     * 装饰器可以选择是否要增强这个方法
     */
    @Override
    public void loseLife() {
        decoratedGoat.loseLife();
    }

    /**
     * 获取生命值 - 默认直接转发给被装饰的对象
     * 装饰器通常不需要修改这个方法
     */
    @Override
    public int getLives() {
        return decoratedGoat.getLives();
    }
}