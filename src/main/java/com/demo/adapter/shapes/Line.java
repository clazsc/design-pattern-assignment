package com.demo.adapter.shapes;

import com.demo.adapter.interfaces.Shape;

/**
 * 线条类 - 符合目标接口的具体图形
 */
public class Line implements Shape {
    @Override
    public void draw() {
        System.out.println("正在绘制线条 (调用 Draw() 方法)...");
    }
}