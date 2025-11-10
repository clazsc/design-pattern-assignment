package com.demo.factorymethod.factory.impl;

import com.demo.factorymethod.factory.VehicleFactory;
import com.demo.factorymethod.product.Vehicle;
import com.demo.factorymethod.product.impl.Airplane;

/**
 * 飞机工厂 - 具体工厂
 * 实现工厂方法，专门生产飞机
 */
public class AirplaneFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        System.out.println("飞机制造厂正在生产一架飞机...");
        return new Airplane();
    }
}