package com.demo.adapter.adapters;

import com.demo.adapter.interfaces.Shape;
import com.demo.adapter.shapes.Angle;

/**
 * 角度适配器 - 将Angle类适配到Shape接口
 * 实现对象适配器模式
 */
public class AngleAdapter implements Shape {
    private final Angle angle;

    /**
     * 构造适配器
     * @param angle 需要适配的角度对象
     */
    public AngleAdapter(Angle angle) {
        this.angle = angle;
    }

    @Override
    public void draw() {
        System.out.print("适配器工作：将 Draw() 调用转换为 -> ");
        angle.DrawAngle();
    }
}