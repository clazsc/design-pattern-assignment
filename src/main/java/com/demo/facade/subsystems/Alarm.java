package com.demo.facade.subsystems;

public class Alarm {
    public void activate() {
        System.out.println("警报器已启动...");
    }

    public void deactivate() {
        System.out.println("警报器已关闭...");
    }
}