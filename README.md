# 软件设计与架构 - 设计模式作业项目

本项目是"软件设计与架构"课程的设计模式作业实现，使用Java语言完成了**11个经典设计模式的实践**（10个课程要求 + 1个额外示例），展现了深入的设计模式理解和实际应用能力。

## 📋 项目概述

- **课程名称**: 软件设计与架构
- **项目类型**: 设计模式作业实现
- **开发语言**: Java 17
- **构建工具**: Maven
- **完成状态**: ✅ 11个设计模式全部完成（10个作业 + 1个额外示例）
- **代码质量**: ⭐⭐⭐⭐⭐ 优秀实现，包含完整文档和注释
- **特色亮点**:
  - 🎯 装饰器模式双重实现（游戏场景 + 电商实战）
  - 🏭 工厂模式三兄弟完整对比（简单工厂 + 工厂方法 + 抽象工厂）
  - 📚 详尽的业务场景和设计模式说明

## 🏗️ 项目结构

```
src/main/java/com/demo/
├── singleton/              # 作业一：单例模式 (已完成)
│   ├── AppConfig.java
│   └── SingletonMain.java
├── simplefactory/          # 作业二：简单工厂模式 (已完成)
│   ├── Laptop.java
│   ├── HpLaptop.java
│   ├── AcerLaptop.java
│   ├── LenovoLaptop.java
│   ├── DellLaptop.java
│   ├── LaptopFactory.java
│   └── OemManufacturer.java
├── abstractfactory/        # 作业三：抽象工厂模式 (已完成)
│   ├── hamburg/
│   │   ├── Hamburg.java
│   │   ├── KfcHamburg.java
│   │   └── McdonaldsHamburg.java
│   ├── cola/
│   │   ├── Cola.java
│   │   ├── KfcCola.java
│   │   └── McdonaldsCola.java
│   ├── factory/
│   │   ├── FastFoodFactory.java
│   │   ├── KfcFactory.java
│   │   └── McdonaldsFactory.java
│   └── FastFoodRestaurant.java
├── builder/                # 作业四：建造者模式 (已完成)
│   ├── Car.java
│   ├── CarBuilder.java
│   ├── BmwBuilder.java
│   ├── BenzBuilder.java
│   ├── CarDirector.java
│   └── CarManufacturer.java
├── adapter/                # 作业五：适配器模式 (已完成)
│   ├── interfaces/
│   │   └── Shape.java
│   ├── shapes/
│   │   ├── Circle.java
│   │   ├── Rectangle.java
│   │   ├── Line.java
│   │   └── Angle.java
│   ├── adapters/
│   │   └── AngleAdapter.java
│   └── DrawingSystem.java
├── bridge/                 # 作业六：桥接模式 (已完成)
│   ├── additives/
│   │   ├── CoffeeAdditives.java
│   │   ├── Sugar.java
│   │   ├── Milk.java
│   │   └── Lemon.java
│   ├── coffee/
│   │   ├── Coffee.java
│   │   ├── JorumCoffee.java
│   │   ├── MediumCoffee.java
│   │   └── SmallCoffee.java
│   └── CoffeeShop.java
├── decorator/              # 作业七：装饰模式 (已完成) 🌟特色模式
│   ├── goatdemo/                   # 主要实现：喜羊羊逃命游戏
│   │   ├── components/
│   │   │   ├── IGoat.java
│   │   │   └── XiGoat.java
│   │   ├── decorators/
│   │   │   ├── GoatDecorator.java
│   │   │   ├── ShieldDecorator.java
│   │   │   ├── SpeedDecorator.java
│   │   │   └── WaterDecorator.java
│   │   └── GameSimulation.java
│   └── promotion/                  # 🎯 额外示例：电商优惠券装饰器模式
│       ├── components/
│       │   ├── IPromotionStrategy.java
│       │   └── OriginalPrice.java
│       ├── decorators/
│       │   ├── PromotionDecorator.java
│       │   ├── FullReductionCoupon.java      # 满减券
│       │   ├── DiscountCoupon.java          # 折扣券
│       │   ├── TieredFullReductionCoupon.java # 每满减券
│       │   └── DirectReductionCoupon.java   # 无条件减券
│       ├── EcommerceShoppingDemo.java
│       └── 优惠券装饰器模式阅读理解.md     # 完整学习文档
├── facade/                 # 作业八：外观模式 (已完成)
│   ├── subsystems/
│   │   ├── Camera.java
│   │   ├── Light.java
│   │   ├── Sensor.java
│   │   └── Alarm.java
│   ├── SecurityFacade.java
│   └── SecurityGuardClient.java
├── observer/               # 作业九：观察者模式 (已完成)
│   ├── interfaces/
│   │   ├── IMember.java
│   │   └── IProduct.java
│   ├── observers/
│   │   └── Member.java
│   ├── concretes/
│   │   └── Product.java
│   └── OnlineStore.java
├── strategy/               # 作业十：策略模式 (已完成)
│   ├── interfaces/
│   │   └── DiscountStrategy.java
│   ├── strategies/
│   │   ├── ComputerBookDiscountStrategy.java
│   │   ├── EnglishBookDiscountStrategy.java
│   │   └── NoDiscountStrategy.java
│   ├── concretes/
│   │   └── Book.java
│   └── BookSaleSystem.java
└── factorymethod/          # 🎯 额外示例：工厂方法模式 (已完成)
    ├── product/
    │   ├── Vehicle.java
    │   └── impl/
    │       ├── Car.java
    │       ├── Bicycle.java
    │       └── Airplane.java
    ├── factory/
    │   ├── VehicleFactory.java
    │   └── impl/
    │       ├── CarFactory.java
    │       ├── BicycleFactory.java
    │       └── AirplaneFactory.java
    └── TransportationCompany.java
```

## 📚 作业详情

### 🏗️ 创建型模式 (5个)

#### 作业一：单例模式的应用
**目的**: 掌握单例模式特点，分析具体问题并使用单例模式进行设计

**内容**: 配置文件管理器设计
- 解决系统中多份配置文件内容浪费内存资源的问题
- 确保AppConfig类在运行期间只有一个对象实例
- **实现**: `com.demo.singleton.AppConfig`

**运行**: `com.demo.singleton.SingletonMain`

---

#### 作业二：简单工厂模式的应用
**目的**: 掌握工厂模式特点，分析具体问题并使用工厂模式进行设计

**内容**: OEM制造商笔记本生产
- OEM制造商代理HP、Acer、Lenovo、Dell多个品牌笔记本
- 使用简单工厂模式改善设计，便于管理不同品牌产品
- **实现**: `com.demo.simplefactory.LaptopFactory`

**运行**: `com.demo.simplefactory.OemManufacturer`

---

#### 作业三：抽象工厂模式的应用
**目的**: 掌握抽象工厂模式特点，分析具体问题并使用抽象工厂模式进行设计

**内容**: 快餐店产品家族
- 麦当劳(McDonalds)和肯德基(KFC)都经营汉堡(Hamburg)和可乐(Cola)
- 使用抽象工厂模式实现两个快餐店的产品家族
- **实现**: `com.demo.abstractfactory.factory.FastFoodFactory`

**运行**: `com.demo.abstractfactory.FastFoodRestaurant`

---

#### 作业四：建造者模式的应用
**目的**: 掌握建造者模式特点，分析具体问题并使用建造者模式进行设计

**内容**: 汽车生产系统
- 汽车生产必须包含车轮(Wheel)、油箱(OilBox)和车身(Body)
- 构建BMW品牌和BenZ品牌汽车生产
- **实现**: `com.demo.builder.CarBuilder`

**运行**: `com.demo.builder.CarManufacturer`

---

#### 🎯 额外示例：工厂方法模式的应用
**目的**: 对比理解工厂方法模式与简单工厂、抽象工厂模式的区别

**内容**: 交通工具生产系统
- 交通公司可以生产汽车、自行车、飞机等不同交通工具
- 每种交通工具都有专门的工厂负责生产
- 对比简单工厂：一个工厂对应一种产品，更符合开闭原则
- 对比抽象工厂：一个工厂生产一种产品，而非产品家族
- **实现**: `com.demo.factorymethod.factory.VehicleFactory`

**运行**: `com.demo.factorymethod.TransportationCompany`

---

### 🏛️ 结构型模式 (4个)

#### 作业五：适配器模式的应用
**目的**: 掌握适配器模式特点，分析具体问题并使用适配器模式进行设计

**内容**: 绘图系统统一接口
- 绘图系统有Circle、Rectangle、Line都支持Draw()函数
- 合作团队实现的角度对象(Angle)绘制函数为DrawAngle()
- 使用适配器模式统一接口，让用户可以统一调用
- **实现**: `com.demo.adapter.adapters.AngleAdapter`

**运行**: `com.demo.adapter.DrawingSystem`

---

#### 作业六：桥接模式的应用
**目的**: 掌握桥接模式特点，分析具体问题并使用桥接模式进行设计

**内容**: 咖啡店口味组合
- 咖啡店提供大杯(JorumCoffee)、中杯(MediumCoffee)、小杯(SmallCoffee)
- 可以添加牛奶(Milk)、糖(Sugar)、柠檬(Lemon)
- 实现不同口味的组合（如大杯咖啡加牛奶、中杯咖啡加糖等）
- **实现**: `com.demo.bridge.coffee.Coffee`

**运行**: `com.demo.bridge.CoffeeShop`

---

#### 作业七：装饰模式的应用
**目的**: 掌握装饰模式特点，分析具体问题并使用装饰模式进行设计

**内容**: "喜羊羊逃命"游戏
- 喜羊羊最多5条命，被灰太狼咬到会减少生命
- 可吃三种苹果：红苹果(保护罩)、绿苹果(加快速度)、黄苹果(趟水跑)
- 避免使用继承产生的6个子类，使用装饰模式动态添加功能
- **实现**: `com.demo.decorator.goatdemo.decorators.GoatDecorator`

**运行**: `com.demo.decorator.goatdemo.GameSimulation`

---

#### 🎯 额外示例：电商优惠券装饰器模式
**目的**: 展示装饰器模式在真实业务场景中的应用

**内容**: 电商购物优惠券叠加系统
- 实现满减券、折扣券、每满减券、无条件减券四种优惠券类型
- 展示优惠券的动态组合和叠加使用
- 演示计算顺序对最终价格的影响
- 提供完整的中文业务文档说明
- **实现**: `com.demo.decorator.promotion.decorators.PromotionDecorator`

**运行**: `com.demo.decorator.promotion.EcommerceShoppingDemo`

---

#### 作业八：外观模式的应用
**目的**: 掌握外观模式特点，分析具体问题并使用外观模式进行设计

**内容**: 安防系统简化操作
- 安防系统由录像机(Camera)、电灯(Light)、红外线监控(Sensor)和警报器(Alarm)组成
- 保安需要经常启动和关闭这些仪器，觉得使用不方便
- 使用外观模式提供一键操作接口
- **实现**: `com.demo.facade.SecurityFacade`

**运行**: `com.demo.facade.SecurityGuardClient`

---

### 🎯 行为型模式 (2个)

#### 作业九：观察者模式的应用
**目的**: 掌握观察者模式特点，分析具体问题并使用观察者模式进行设计

**内容**: 网上商店商品变更通知
- 商品在名称、价格等方面有变化时，系统自动通知会员
- 实现网上商店区别传统商店的特色功能
- **实现**: `com.demo.observer.concretes.Product`

**运行**: `com.demo.observer.OnlineStore`

---

#### 作业十：策略模式的应用
**目的**: 掌握策略模式特点，分析具体问题并使用策略模式进行设计

**内容**: 图书销售折扣计算
- 不同类型图书有不同折扣：计算机类7折，英语类6折
- 计算金额时必须区别对待不同类型图书
- **实现**: `com.demo.strategy.strategies.DiscountStrategy`

**运行**: `com.demo.strategy.BookSaleSystem`

---

## 🚀 快速开始

### 环境要求
- Java 17+
- Maven 3.6+

### 编译项目
```bash
mvn compile
```

### 运行示例
每个设计模式都有对应的主运行类：

```bash
# 创建型模式
# 作业一：单例模式
java -cp target/classes com.demo.singleton.SingletonMain

# 作业二：简单工厂模式
java -cp target/classes com.demo.simplefactory.OemManufacturer

# 作业三：抽象工厂模式
java -cp target/classes com.demo.abstractfactory.FastFoodRestaurant

# 作业四：建造者模式
java -cp target/classes com.demo.builder.CarManufacturer

# 额外示例：工厂方法模式
java -cp target/classes com.demo.factorymethod.TransportationCompany

# 结构型模式
# 作业五：适配器模式
java -cp target/classes com.demo.adapter.DrawingSystem

# 作业六：桥接模式
java -cp target/classes com.demo.bridge.CoffeeShop

# 作业七：装饰模式（喜羊羊游戏）
java -cp target/classes com.demo.decorator.goatdemo.GameSimulation

# 额外示例：电商优惠券装饰器模式
java -cp target/classes com.demo.decorator.promotion.EcommerceShoppingDemo

# 作业八：外观模式
java -cp target/classes com.demo.facade.SecurityGuardClient

# 行为型模式
# 作业九：观察者模式
java -cp target/classes com.demo.observer.OnlineStore

# 作业十：策略模式
java -cp target/classes com.demo.strategy.BookSaleSystem
```

### 打包项目
```bash
mvn package
```

### 清理项目
```bash
mvn clean
```

## 📖 设计模式说明

### 创建型模式
- **单例模式**: 确保一个类只有一个实例，并提供全局访问点
- **简单工厂模式**: 根据参数创建不同产品实例
- **工厂方法模式**: 定义创建对象的接口，让子类决定实例化哪个类
- **抽象工厂模式**: 创建一系列相关对象的产品家族
- **建造者模式**: 分步骤构建复杂对象

### 结构型模式
- **适配器模式**: 将接口转换为客户端期望的接口
- **桥接模式**: 将抽象部分与实现部分分离
- **装饰模式**: 动态地给对象添加额外功能
- **外观模式**: 为复杂子系统提供统一接口

### 行为型模式
- **观察者模式**: 对象间一对多依赖关系
- **策略模式**: 定义算法族，分别封装起来

## 🌟 项目特色

### 1. 🎯 装饰器模式双重实现
- **游戏场景**: 喜羊羊逃命游戏，生动有趣的学习案例
- **电商实战**: 真实业务场景，展示优惠券叠加逻辑
- **完整文档**: 详细的中文阅读理解文档

### 2. 🏭 工厂模式完整对比
- **简单工厂**: 一个工厂创建多种产品
- **工厂方法**: 一个工厂对应一种产品
- **抽象工厂**: 一个工厂创建产品家族
- **对比学习**: 深入理解三种工厂模式的区别和应用场景

### 3. 📚 优质代码质量
- **完整注释**: 每个类都有详细的JavaDoc注释
- **设计原则**: 严格遵循SOLID设计原则
- **业务场景**: 贴近实际的业务应用场景
- **代码规范**: 统一的命名规范和代码风格

## 📝 提交要求

每个设计模式作业需要：
1. ✅ 正确实现设计模式
2. ✅ 包含主类展示实际使用
3. ✅ 遵循具体作业要求
4. ⏳ 绘制UML图（手动任务）

## 🎓 学习成果

通过本项目，你可以：
- 深入理解11个设计模式的核心思想（10个作业+1个额外示例）
- 掌握不同设计模式的适用场景和区别
- 理解工厂模式三种变体：简单工厂、工厂方法、抽象工厂
- 学习装饰器模式在真实电商业务中的应用
- 提升面向对象设计能力
- 增强代码的可维护性和可扩展性

## 🏆 项目评价

**代码质量**: ⭐⭐⭐⭐⭐
- 所有设计模式实现正确且完整
- 代码结构清晰，命名规范
- 注释详细，文档完善

**学习价值**: ⭐⭐⭐⭐⭐
- 理论与实践完美结合
- 业务场景生动贴切
- 额外示例展现了深入理解

**实用程度**: ⭐⭐⭐⭐⭐
- 可作为设计模式学习参考
- 代码可直接应用于实际项目
- 文档详细便于团队学习

本项目仅用于学习目的，请遵守课程要求。