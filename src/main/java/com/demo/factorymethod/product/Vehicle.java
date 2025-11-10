package com.demo.factorymethod.product;

/**
 * 交通工具抽象产品接口
 */
public interface Vehicle {
    /**
     * 显示交通工具信息
     */
    void displayInfo();

    /**
     * 启动交通工具
     */
    void start();

    /**
     * 停止交通工具
     */
    void stop();
}