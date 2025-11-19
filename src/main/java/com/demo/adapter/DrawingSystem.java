package com.demo.adapter;

import com.demo.adapter.interfaces.Shape;
import com.demo.adapter.shapes.*;
import com.demo.adapter.adapters.AngleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 绘图系统客户端 - 适配器模式演示
 * 展示如何统一处理符合接口的图形和需要适配的遗留类
 */
public class DrawingSystem {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        // 添加符合目标接口的图形
        shapes.add(new Circle());
        shapes.add(new Rectangle());
        shapes.add(new Line());

        // 使用适配器包装不兼容的Angle类
        Angle legacyAngle = new Angle();
        Shape adaptedAngle = new AngleAdapter(legacyAngle);
        shapes.add(adaptedAngle);

        // 统一绘制所有图形，无需关心具体实现
        System.out.println("\n开始统一绘制所有图形...");
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}