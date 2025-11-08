package com.demo.strategy;

import com.demo.strategy.concretes.Book;
import com.demo.strategy.interfaces.DiscountStrategy;
import com.demo.strategy.strategies.ComputerBookDiscountStrategy;
import com.demo.strategy.strategies.EnglishBookDiscountStrategy;
import com.demo.strategy.strategies.NoDiscountStrategy;

public class BookSaleSystem {
    public static void main(String[] args) {
        // 预先创建好各种策略对象
        DiscountStrategy computerStrategy = new ComputerBookDiscountStrategy();
        DiscountStrategy englishStrategy = new EnglishBookDiscountStrategy();
        DiscountStrategy noDiscountStrategy = new NoDiscountStrategy();

        // 顾客购买不同类型的图书
        System.out.println("--- 顾客A购买了一本计算机图书 ---");
        // 创建图书时，为其注入计算机图书的折扣策略
        Book computerBook = new Book("《Java编程思想》", 120.0, computerStrategy);
        double finalPriceA = computerBook.getFinalPrice();
        System.out.println("图书: " + computerBook.getTitle() + " | 原价: 120.0元 | 折后价: " + finalPriceA + "元");

        System.out.println("\n--- 顾客B购买了一本英语图书 ---");
        // 创建图书时，为其注入英语图书的折扣策略
        Book englishBook = new Book("《新概念英语》", 90.0, englishStrategy);
        double finalPriceB = englishBook.getFinalPrice();
        System.out.println("图书: " + englishBook.getTitle() + " | 原价: 90.0元 | 折后价: " + finalPriceB + "元");

        System.out.println("\n--- 顾客C购买了一本小说 ---");
        // 创建图书时，为其注入无折扣的策略
        Book novelBook = new Book("《三体》", 118.0, noDiscountStrategy);
        double finalPriceC = novelBook.getFinalPrice();
        System.out.println("图书: " + novelBook.getTitle() + " | 原价: 118.0元 | 折后价: " + finalPriceC + "元");
    }
}