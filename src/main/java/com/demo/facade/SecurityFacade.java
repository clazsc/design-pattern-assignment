package com.demo.facade;

import com.demo.facade.subsystems.Camera;
import com.demo.facade.subsystems.Light;
import com.demo.facade.subsystems.Sensor;
import com.demo.facade.subsystems.Alarm;

public class SecurityFacade {
    private Camera camera;
    private Light light;
    private Sensor sensor;
    private Alarm alarm;

    public SecurityFacade() {
        this.camera = new Camera();
        this.light = new Light();
        this.sensor = new Sensor();
        this.alarm = new Alarm();
    }

    public void activate() {
        System.out.println("正在启动一键安保模式...");
        light.turnOn();
        sensor.activate();
        camera.turnOn();
        alarm.activate();
        System.out.println("一键安保模式已成功启动！");
    }

    public void deactivate() {
        System.out.println("正在关闭一键安保模式...");
        alarm.deactivate();
        camera.turnOff();
        sensor.deactivate();
        light.turnOff();
        System.out.println("一键安保模式已安全关闭！");
    }
}