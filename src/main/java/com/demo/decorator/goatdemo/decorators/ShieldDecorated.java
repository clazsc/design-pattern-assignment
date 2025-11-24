package com.demo.decorator.goatdemo.decorators;

import com.demo.decorator.goatdemo.components.IGoat;

/**
 * 保护罩装饰器 - 具体装饰器实现
 *
 * 装饰器模式中的ConcreteDecorator角色，为喜羊羊添加保护罩功能
 * 对应游戏中的红苹果道具，让喜羊羊在逃跑时获得保护罩
 *
 * 设计模式角色：ConcreteDecorator（具体装饰器）
 *
 * 装饰器效果：在逃跑时增加保护罩，提供额外的安全防护
 */
public class ShieldDecorated extends DecoratedGoat {
    /**
     * 构造函数，传入要被装饰的羊对象
     * @param goat 要被装饰的羊对象
     */
    public ShieldDecorated(IGoat goat) {
        super(goat);
    }

    /**
     * 增强的逃跑方法
     * 在原有逃跑基础上添加保护罩效果
     * 装饰器模式的精髓：先添加自己的功能，再调用被装饰对象的方法
     */
    @Override
    public void flee() {
        // 注意：由于是“装饰”，所以并不是仅以新装饰后的方法覆盖原方法，而是“装饰”，原方法仍要调用！
        // 这样才是支持“嵌套”，无限“叠加装饰”的本质原因
        System.out.print("【开启保护罩！】-> ");
        super.flee();  // 调用被装饰对象的原始方法
    }
}