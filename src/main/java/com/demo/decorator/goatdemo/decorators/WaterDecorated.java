package com.demo.decorator.goatdemo.decorators;

import com.demo.decorator.goatdemo.components.IGoat;

/**
 * 趟水装饰器 - 具体装饰器实现
 *
 * 装饰器模式中的ConcreteDecorator角色，为喜羊羊添加趟水跑功能
 * 对应游戏中的黄苹果道具，让喜羊羊可以在水中逃跑
 *
 * 设计模式角色：ConcreteDecorator（具体装饰器）
 *
 * 装饰器效果：在逃跑时获得趟水能力，扩展逃生环境适应性
 */
public class WaterDecorated extends DecoratedGoat {
    /**
     * 构造函数，传入要被装饰的羊对象
     * @param goat 要被装饰的羊对象
     */
    public WaterDecorated(IGoat goat) {
        super(goat);
    }

    /**
     * 增强的逃跑方法
     * 在原有逃跑基础上添加趟水跑效果
     * 体现装饰器模式的灵活性：可以为对象添加完全不同的能力
     */
    @Override
    public void flee() {
        System.out.print("【学会了趟水跑！】-> ");
        super.flee();  // 调用被装饰对象的原始方法
    }
}