package com.demo.factorymethod.product.impl;

import com.demo.factorymethod.product.Vehicle;

/**
 * 自行车 - 具体产品
 */
public class Bicycle implements Vehicle {
    @Override
    public void displayInfo() {
        System.out.println("🚲 自行车：环保健康的人力交通工具，适合短途出行");
    }

    @Override
    public void start() {
        System.out.println("自行车启动：踩踏板，保持平衡");
    }

    @Override
    public void stop() {
        System.out.println("自行车停止：刹车，下车支撑");
    }
}