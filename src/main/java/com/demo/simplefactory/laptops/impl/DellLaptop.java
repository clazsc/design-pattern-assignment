package com.demo.simplefactory.laptops.impl;

import com.demo.simplefactory.laptops.Laptop;

/**
 * 戴尔电脑
 */
public class DellLaptop implements Laptop {
    @Override
    public void assemble() {
        System.out.println("正在组装一台 Dell 笔记本电脑...");
    }
}