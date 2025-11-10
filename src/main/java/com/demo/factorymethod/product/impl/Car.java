package com.demo.factorymethod.product.impl;

import com.demo.factorymethod.product.Vehicle;

/**
 * 小汽车 - 具体产品
 */
public class Car implements Vehicle {
    @Override
    public void displayInfo() {
        System.out.println("🚗 小汽车：四轮载人交通工具，适合城市道路行驶");
    }

    @Override
    public void start() {
        System.out.println("小汽车启动：引擎发动，方向盘就位");
    }

    @Override
    public void stop() {
        System.out.println("小汽车停止：熄火，拉手刹");
    }
}