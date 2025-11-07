package com.demo.simplefactory.laptops.impl;

import com.demo.simplefactory.laptops.Laptop;

/**
 * 宏碁电脑
 */
public class AcerLaptop implements Laptop {
    @Override
    public void assemble() {
        System.out.println("正在组装一台 Acer 笔记本电脑...");
    }
}