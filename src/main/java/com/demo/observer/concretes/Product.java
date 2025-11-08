package com.demo.observer.concretes;

import com.demo.observer.interfaces.IMember;
import com.demo.observer.interfaces.IProduct;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Product implements IProduct {
    private List<IMember> members = new ArrayList<>();
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        System.out.println("\n系统消息：商品 '" + this.name + "' 价格正在从 " + this.price + " 更新为 " + price);
        this.price = price;
        this.notifyObservers();
    }

    @Override
    public void attach(IMember member) {
        if (!members.contains(member)) {
            members.add(member);
        }
    }

    @Override
    public void detach(IMember member) {
        members.remove(member);
    }

    @Override
    public void notifyObservers() {
        for (IMember member : members) {
            member.update(this);
        }
    }
}