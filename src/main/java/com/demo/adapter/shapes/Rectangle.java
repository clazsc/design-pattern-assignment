package com.demo.adapter.shapes;

import com.demo.adapter.interfaces.Shape;

/**
 * 矩形类 - 符合目标接口的具体图形
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("正在绘制矩形 (调用 Draw() 方法)...");
    }
}