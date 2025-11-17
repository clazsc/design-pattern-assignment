package com.demo.decorator.goatdemo.components;

/**
 * 喜羊羊类 - 具体组件实现
 *
 * 装饰器模式中的ConcreteComponent角色，是真正被装饰的对象
 * 提供了基本的羊的行为：逃跑、被咬、管理生命值
 *
 * 设计模式角色：ConcreteComponent（具体组件）
 */
public class XiGoat implements IGoat {
    /**
     * 生命值：喜羊羊最多5条命
     */
    private int lives = 5;

    /**
     * 基本逃跑行为
     * 这是喜羊羊的原始能力，没有加任何道具时的逃跑方式
     */
    @Override
    public void flee() {
        System.out.println("喜羊羊正在拼命逃跑！");
    }

    /**
     * 失去生命值
     * 被灰太狼咬到时减少一条生命，有生命值检查
     */
    @Override
    public void loseLife() {
        if (this.lives > 0) {
            this.lives--;
            System.out.println("被灰太狼咬到了，喜羊羊少了一条命！");
        } else {
            System.out.println("喜羊羊已经没有命了...");
        }
    }

    /**
     * 获取当前剩余生命值
     * @return 剩余的生命条数（0-5）
     */
    @Override
    public int getLives() {
        return this.lives;
    }
}