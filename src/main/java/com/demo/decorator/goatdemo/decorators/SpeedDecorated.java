package com.demo.decorator.goatdemo.decorators;

import com.demo.decorator.goatdemo.components.IGoat;

/**
 * 加速装饰器 - 具体装饰器实现
 *
 * 装饰器模式中的ConcreteDecorator角色，为喜羊羊添加加速功能
 * 对应游戏中的绿苹果道具，让喜羊羊逃跑速度更快
 *
 * 设计模式角色：ConcreteDecorator（具体装饰器）
 *
 * 装饰器效果：在逃跑时提升速度，增加逃脱成功率
 */
public class SpeedDecorated extends DecoratedGoat {
    /**
     * 构造函数，传入要被装饰的羊对象
     * @param goat 要被装饰的羊对象
     */
    public SpeedDecorated(IGoat goat) {
        super(goat);
    }

    /**
     * 增强的逃跑方法
     * 在原有逃跑基础上添加速度提升效果
     * 展示装饰器模式如何动态为对象添加新功能
     */
    @Override
    public void flee() {
        System.out.print("【奔跑速度加快！】-> ");
        super.flee();  // 调用被装饰对象的原始方法
    }
}