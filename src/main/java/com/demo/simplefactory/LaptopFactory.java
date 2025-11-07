package com.demo.simplefactory;

import com.demo.simplefactory.laptops.*;
import com.demo.simplefactory.laptops.impl.AcerLaptop;
import com.demo.simplefactory.laptops.impl.DellLaptop;
import com.demo.simplefactory.laptops.impl.HpLaptop;
import com.demo.simplefactory.laptops.impl.LenovoLaptop;

class LaptopFactory {
    /**
     * 根据指定的品牌创建并返回一个笔记本电脑实例。
     * @param brand 笔记本电脑的品牌，如 "HP", "Acer", "Lenovo", "Dell"。
     * @return 对应品牌的 Laptop 对象，如果品牌不支持则返回 null。
     */
    public Laptop createLaptop(String brand) {
        // 对输入的品牌字符串进行健壮性检查
        if (brand == null || brand.isEmpty()) {
            return null;
        }

        // 使用 equalsIgnoreCase 来忽略大小写，提高容错性
        if ("HP".equalsIgnoreCase(brand)) {
            return new HpLaptop();
        } else if ("Acer".equalsIgnoreCase(brand)) {
            return new AcerLaptop();
        } else if ("Lenovo".equalsIgnoreCase(brand)) {
            return new LenovoLaptop();
        } else if ("Dell".equalsIgnoreCase(brand)) {
            return new DellLaptop();
        }

        // 如果没有匹配的品牌，返回 null
        return null;
    }
}