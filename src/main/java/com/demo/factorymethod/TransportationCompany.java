package com.demo.factorymethod;

import com.demo.factorymethod.factory.VehicleFactory;
import com.demo.factorymethod.factory.impl.AirplaneFactory;
import com.demo.factorymethod.factory.impl.BicycleFactory;
import com.demo.factorymethod.factory.impl.CarFactory;
import com.demo.factorymethod.product.Vehicle;

/**
 * 交通公司客户端
 * 演示工厂方法模式的使用
 */
public class TransportationCompany {
    public static void main(String[] args) {
        System.out.println("=== 工厂方法模式演示 ===\n");

        // 场景1：城市短途出行
        System.out.println("【场景1：城市短途出行】");
        VehicleFactory carFactory = new CarFactory();
        Vehicle car = carFactory.createVehicle();

        car.displayInfo();
        car.start();
        car.stop();

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 场景2：校园内出行
        System.out.println("【场景2：校园内出行】");
        VehicleFactory bicycleFactory = new BicycleFactory();
        Vehicle bicycle = bicycleFactory.createVehicle();

        bicycle.displayInfo();
        bicycle.start();
        bicycle.stop();

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 场景3：跨国长途旅行
        System.out.println("【场景3：跨国长途旅行】");
        VehicleFactory airplaneFactory = new AirplaneFactory();
        Vehicle airplane = airplaneFactory.createVehicle();

        airplane.displayInfo();
        airplane.start();
        airplane.stop();

        System.out.println("\n=== 演示结束 ===");
        System.out.println("\n工厂方法模式特点：");
        System.out.println("✓ 每个具体工厂只负责创建一种产品");
        System.out.println("✓ 客户端只需要知道具体的工厂类就能创建产品");
        System.out.println("✓ 新增产品类型时，只需添加新的工厂类");
        System.out.println("✓ 符合开闭原则，对扩展开放，对修改关闭");
    }
}