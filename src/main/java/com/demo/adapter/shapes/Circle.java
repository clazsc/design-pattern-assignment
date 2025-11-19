package com.demo.adapter.shapes;

import com.demo.adapter.interfaces.Shape;

/**
 * 圆形类 - 符合目标接口的具体图形
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("正在绘制圆形 (调用 Draw() 方法)...");
    }
}