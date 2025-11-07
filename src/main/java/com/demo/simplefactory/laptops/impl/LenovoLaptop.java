package com.demo.simplefactory.laptops.impl;

import com.demo.simplefactory.laptops.Laptop;

/**
 * 联想电脑
 */
public class LenovoLaptop implements Laptop {
    @Override
    public void assemble() {
        System.out.println("正在组装一台 Lenovo 笔记本电脑...");
    }
}