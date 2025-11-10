package com.demo.factorymethod.factory.impl;

import com.demo.factorymethod.factory.VehicleFactory;
import com.demo.factorymethod.product.Vehicle;
import com.demo.factorymethod.product.impl.Car;

/**
 * 汽车工厂 - 具体工厂
 * 实现工厂方法，专门生产汽车
 */
public class CarFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        System.out.println("汽车工厂正在生产一辆小汽车...");
        return new Car();
    }
}