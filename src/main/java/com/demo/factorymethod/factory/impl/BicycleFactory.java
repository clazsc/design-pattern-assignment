package com.demo.factorymethod.factory.impl;

import com.demo.factorymethod.factory.VehicleFactory;
import com.demo.factorymethod.product.Vehicle;
import com.demo.factorymethod.product.impl.Bicycle;

/**
 * 自行车工厂 - 具体工厂
 * 实现工厂方法，专门生产自行车
 */
public class BicycleFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        System.out.println("自行车工厂正在生产一辆自行车...");
        return new Bicycle();
    }
}