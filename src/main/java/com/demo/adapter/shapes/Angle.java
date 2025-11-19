package com.demo.adapter.shapes;

/**
 * 角度类 - 需要适配的遗留类
 * 该类接口不兼容，需要通过适配器才能使用
 */
public class Angle {
    /**
     * 绘制角度 - 方法名与目标接口不一致
     */
    public void DrawAngle() {
        System.out.println("正在绘制角度 (调用 DrawAngle() 方法)...");
    }
}