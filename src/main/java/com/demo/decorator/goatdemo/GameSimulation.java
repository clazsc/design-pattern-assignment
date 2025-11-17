package com.demo.decorator.goatdemo;

import com.demo.decorator.goatdemo.components.IGoat;
import com.demo.decorator.goatdemo.components.XiGoat;
import com.demo.decorator.goatdemo.decorators.ShieldDecorated;
import com.demo.decorator.goatdemo.decorators.SpeedDecorated;
import com.demo.decorator.goatdemo.decorators.WaterDecorated;

/**
 * 游戏模拟客户端 - 装饰器模式演示程序
 *
 * 演示"喜羊羊逃命"游戏中如何使用装饰器模式动态添加能力
 * 展示了装饰器模式的核心优势：不使用继承，通过组合动态扩展功能
 *
 * 装饰器模式的关键优势：
 * 1. 避免了继承爆炸：如果用继承，需要 2^3 = 8 个子类
 * 2. 运行时动态组合：可以任意组合不同的装饰器
 * 3. 符合开闭原则：新增装饰器不需要修改现有代码
 * 4. 保持接口一致性：装饰后的对象仍然实现相同接口
 */
public class GameSimulation {
    public static void main(String[] args) {
        System.out.println("=== 装饰器模式演示：喜羊羊逃命 ===\n");

        // 创建原始的喜羊羊对象（ConcreteComponent）
        System.out.println("--- 游戏开始，灰太狼出现了！ ---");
        IGoat xiyangyang = new XiGoat();
        System.out.println("当前状态：");
        xiyangyang.flee();  // 基础逃跑能力
        System.out.println("剩余生命值: " + xiyangyang.getLives());

        // 模拟被灰太狼咬到
        System.out.println("\n--- 糟糕！喜羊羊被咬了 ---");
        xiyangyang.loseLife();
        System.out.println("剩余生命值: " + xiyangyang.getLives());

        // 第一次装饰：添加保护罩（ConcreteDecorator）
        System.out.println("\n--- 喜羊羊吃到了一个红苹果！ ---");
        xiyangyang = new ShieldDecorated(xiyangyang);  // 装饰器链：Shield -> XiGoat
        System.out.println("当前状态：");
        xiyangyang.flee();  // 现在逃跑时有保护罩

        // 第二次装饰：添加速度（装饰器链扩展）
        System.out.println("\n--- 喜羊羊又吃到了一个绿苹果！ ---");
        xiyangyang = new SpeedDecorated(xiyangyang);   // 装饰器链：Speed -> Shield -> XiGoat
        System.out.println("当前状态：");
        xiyangyang.flee();  // 现在逃跑时有速度+保护罩

        // 第三次装饰：添加趟水能力（装饰器链进一步扩展）
        System.out.println("\n--- 逃到河边，喜羊羊吃了一个黄苹果！ ---");
        xiyangyang = new WaterDecorated(xiyangyang);   // 装饰器链：Water -> Speed -> Shield -> XiGoat
        System.out.println("当前状态：");
        xiyangyang.flee();  // 现在逃跑时有全部三种能力

        // 验证装饰器不影响核心功能
        System.out.println("\n--- 灰太狼追了上来！ ---");
        xiyangyang.loseLife();  // 生命值管理仍然正常工作
        System.out.println("剩余生命值: " + xiyangyang.getLives());

        System.out.println("\n=== 装饰器模式演示总结 ===");
        System.out.println("✓ 避免了继承爆炸：3种道具组合需要8个子类，装饰器模式只需4个类");
        System.out.println("✓ 运行时动态组合：可以任意顺序添加装饰器");
        System.out.println("✓ 保持接口一致：装饰后的对象仍然是IGoat");
        System.out.println("✓ 功能叠加效果：多个装饰器可以同时生效");
        System.out.println("\n--- 喜羊羊成功逃脱！游戏结束 ---");
    }
}