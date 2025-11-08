package com.demo.observer;

import com.demo.observer.concretes.Product;
import com.demo.observer.interfaces.IMember;
import com.demo.observer.observers.Member;

public class OnlineStore {
    public static void main(String[] args) {
        Product phone = new Product("华为Mate 60 Pro", 6999.00);

        IMember memberZhang = new Member("张三");
        IMember memberLi = new Member("李四");
        IMember memberWang = new Member("王五");

        phone.attach(memberZhang);
        phone.attach(memberLi);
        System.out.println("--- 张三和李四关注了手机 ---");

        phone.setPrice(6499.00);

        System.out.println("\n--- 王五关注了手机，李四取消了关注 ---");
        phone.attach(memberWang);
        phone.detach(memberLi);

        phone.setPrice(6699.00);
    }
}