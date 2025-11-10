package com.demo.factorymethod.factory;

import com.demo.factorymethod.product.Vehicle;

/**
 * 交通工具抽象工厂接口
 * 工厂方法模式的核心：定义创建产品的抽象方法
 */
public interface VehicleFactory {
    /**
     * 工厂方法：创建交通工具
     * @return Vehicle 实例
     */
    Vehicle createVehicle();
}