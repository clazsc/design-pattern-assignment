package com.demo.factorymethod.product.impl;

import com.demo.factorymethod.product.Vehicle;

/**
 * 飞机 - 具体产品
 */
public class Airplane implements Vehicle {
    @Override
    public void displayInfo() {
        System.out.println("✈️ 飞机：空中快速交通工具，适合长途旅行");
    }

    @Override
    public void start() {
        System.out.println("飞机启动：引擎预热，滑行准备起飞");
    }

    @Override
    public void stop() {
        System.out.println("飞机停止：降落，引擎减速，停泊");
    }
}