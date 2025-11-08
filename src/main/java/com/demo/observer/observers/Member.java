package com.demo.observer.observers;

import com.demo.observer.interfaces.IMember;
import com.demo.observer.concretes.Product;

public class Member implements IMember {
    private String name;

    public Member(String name) {
        this.name = name;
    }

    @Override
    public void update(Product product) {
        System.out.println("通知 -> 尊敬的会员 " + this.name + ":");
        System.out.println("    您关注的商品 '" + product.getName() + "' 价格已更新为 " + product.getPrice() + "元！");
    }
}