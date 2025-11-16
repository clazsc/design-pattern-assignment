package com.demo.decorator.components;

/**
 * 羊接口 - 装饰器模式的核心组件接口
 *
 * 装饰器模式中的Component角色，定义了被装饰对象的基本行为
 * 所有具体组件和装饰器都需要实现这个接口
 *
 * 设计模式角色：Component（组件接口）
 */
public interface IGoat {
    /**
     * 逃跑方法
     * 羊被灰太狼追击时的基本行为
     */
    void flee();

    /**
     * 失去生命值
     * 被灰太狼咬到时触发，减少一条生命
     */
    void loseLife();

    /**
     * 获取当前剩余生命值
     * @return 剩余的生命条数
     */
    int getLives();
}