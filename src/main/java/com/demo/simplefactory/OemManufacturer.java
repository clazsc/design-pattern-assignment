package com.demo.simplefactory;

import com.demo.simplefactory.laptops.Laptop;

/**
 * 客户端：OEM 制造商，使用工厂来生产笔记本电脑。
 */
public class OemManufacturer {
    public static void main(String[] args) {
        // 创建一个笔记本电脑工厂
        LaptopFactory factory = new LaptopFactory();

        System.out.println("OEM 制造商开始生产...");

        // 接收到不同品牌的订单

        // 订单 1: 生产一台 HP 笔记本
        Laptop hpLaptop = factory.createLaptop("HP");
        if (hpLaptop != null) {
            hpLaptop.assemble();
        }

        // 订单 2: 生产一台 Acer 笔记本
        Laptop acerLaptop = factory.createLaptop("Acer");
        if (acerLaptop != null) {
            acerLaptop.assemble();
        }

        // 订单 3: 生产一台 Lenovo 笔记本
        Laptop lenovoLaptop = factory.createLaptop("Lenovo");
        if (lenovoLaptop != null) {
            lenovoLaptop.assemble();
        }

        // 订单 4: 生产一台 Dell 笔记本
        Laptop dellLaptop = factory.createLaptop("Dell");
        if (dellLaptop != null) {
            dellLaptop.assemble();
        }

        // 订单 5: 尝试生产一个不支持的品牌
        System.out.println("\n接到一个 'Asus' 的订单...");
        Laptop unknownLaptop = factory.createLaptop("Asus");
        if (unknownLaptop == null) {
            System.out.println("生产失败：工厂不支持 'Asus' 品牌。");
        }

        System.out.println("\n今日生产结束。");
    }
}