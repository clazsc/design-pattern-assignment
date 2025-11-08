package com.demo.facade;

public class SecurityGuardClient {
    public static void main(String[] args) {
        System.out.println("--- 保安上班了 ---");
        SecurityFacade securitySystem = new SecurityFacade();

        System.out.println("保安需要启动所有设备：");
        securitySystem.activate();

        System.out.println("\n--- 保安准备下班 ---");
        System.out.println("保安需要关闭所有设备：");
        securitySystem.deactivate();
    }
}