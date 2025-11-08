package com.demo.facade.subsystems;

public class Sensor {
    public void activate() {
        System.out.println("红外线感应器已启动...");
    }

    public void deactivate() {
        System.out.println("红外线感应器已关闭...");
    }
}