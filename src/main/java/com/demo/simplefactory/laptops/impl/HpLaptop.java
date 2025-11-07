package com.demo.simplefactory.laptops.impl;

import com.demo.simplefactory.laptops.Laptop;

/**
 * 惠普电脑
 */
public class HpLaptop implements Laptop {
    @Override
    public void assemble() {
        System.out.println("正在组装一台 HP 笔记本电脑...");
    }
}