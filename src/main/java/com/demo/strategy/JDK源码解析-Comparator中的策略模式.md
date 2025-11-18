# JDK源码解析 - Comparator中的策略模式

## 概述

JDK中的 `java.util.Arrays` 类提供了一个完美的策略模式应用实例。通过 `Arrays.sort()` 方法结合 `Comparator` 接口，我们可以在运行时动态地指定不同的排序策略，而无需修改 Arrays 类本身的代码。

## JDK源码分析

### 1. Arrays类 - 环境角色（Context）

```java
public class Arrays {
    /**
     * 使用自定义比较器对数组进行排序
     *
     * @param a 要排序的数组
     * @param c 比较器，决定排序策略。如果为null，则使用自然排序
     * @param <T> 数组元素类型
     */
    public static <T> void sort(T[] a, Comparator<? super T> c) {
        if (c == null) {
            // 如果没有提供比较器，使用自然排序策略
            sort(a);
        } else {
            // 使用提供的比较器策略进行排序
            if (LegacyMergeSort.userRequested)
                legacyMergeSort(a, c);
            else
                // 使用 TimSort 算法，传入比较器策略
                TimSort.sort(a, 0, a.length, c, null, 0, 0);
        }
    }
}
```

**设计模式角色分析：**
- **环境角色（Context）**: `Arrays` 类，持有策略的引用并调用策略方法
- **策略接口（Strategy）**: `Comparator<T>` 接口
- **具体策略（ConcreteStrategy）**: 用户提供的 `Comparator` 实现类

### 2. Comparator接口 - 抽象策略角色

```java
@FunctionalInterface
public interface Comparator<T> {
    /**
     * 比较两个参数的顺序
     *
     * @param o1 第一个要比较的对象
     * @param o2 第二个要比较的对象
     * @return 负整数、零或正整数，分别表示第一个参数小于、等于或大于第二个参数
     * @throws NullPointerException 如果参数为null且比较器不允许null参数
     */
    int compare(T o1, T o2);

    // 省略其他默认方法和静态方法...
}
```

### 3. TimSort类 - 策略的使用者

```java
class TimSort<T> {
    /**
     * 使用指定的比较器对数组进行排序
     */
    static <T> void sort(T[] a, int lo, int hi, Comparator<? super T> c,
                        T[] work, int workBase, int workLen) {
        assert c != null && a != null && lo >= 0 && lo <= hi && hi <= a.length;

        int nRemaining = hi - lo;
        if (nRemaining < 2)
            return;  // 大小为0和1的数组总是有序的

        // 如果数组很小，执行一个"迷你TimSort"而不进行合并
        if (nRemaining < MIN_MERGE) {
            int initRunLen = countRunAndMakeAscending(a, lo, hi, c);
            binarySort(a, lo, hi, lo + initRunLen, c);
            return;
        }
        // ... 其他排序逻辑
    }

    /**
     * 计算运行长度并确保数组升序
     * 这里就是真正使用策略的地方
     */
    private static <T> int countRunAndMakeAscending(T[] a, int lo, int hi,
                                                   Comparator<? super T> c) {
        assert lo < hi;
        int runHi = lo + 1;
        if (runHi == hi)
            return 1;

        // 找到运行的结束位置，如果是降序则反转范围
        // 关键：这里调用了策略的 compare 方法
        if (c.compare(a[runHi++], a[lo]) < 0) { // 降序
            while (runHi < hi && c.compare(a[runHi], a[runHi - 1]) < 0)
                runHi++;
            reverseRange(a, lo, runHi);
        } else {                              // 升序
            while (runHi < hi && c.compare(a[runHi], a[runHi - 1]) >= 0)
                runHi++;
        }

        return runHi - lo;
    }
}
```

## 实际应用示例

### 示例1：基本排序策略

```java
public class JdkStrategyDemo {
    public static void main(String[] args) {
        Integer[] data = {12, 2, 3, 2, 4, 5, 1};

        // 策略1：降序排序
        Arrays.sort(data, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;  // 降序策略
            }
        });
        System.out.println("降序: " + Arrays.toString(data)); // [12, 5, 4, 3, 2, 2, 1]

        // 策略2：升序排序（恢复）
        Arrays.sort(data, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;  // 升序策略
            }
        });
        System.out.println("升序: " + Arrays.toString(data)); // [1, 2, 2, 3, 4, 5, 12]
    }
}
```

### 示例2：复杂对象排序策略

```java
public class Student {
    private String name;
    private int age;
    private double score;

    // 构造器、getter、setter省略...

    @Override
    public String toString() {
        return String.format("%s(年龄:%d, 分数:%.1f)", name, age, score);
    }
}

public class StudentSortDemo {
    public static void main(String[] args) {
        Student[] students = {
            new Student("张三", 20, 85.5),
            new Student("李四", 19, 92.0),
            new Student("王五", 21, 78.5)
        };

        // 策略1：按年龄排序
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getAge(), s2.getAge());
            }
        });
        System.out.println("按年龄排序: " + Arrays.toString(students));

        // 策略2：按分数排序
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getScore(), s1.getScore()); // 降序
            }
        });
        System.out.println("按分数排序: " + Arrays.toString(students));

        // 策略3：按姓名排序
        Arrays.sort(students, Comparator.comparing(Student::getName));
        System.out.println("按姓名排序: " + Arrays.toString(students));
    }
}
```

### 示例3：Lambda表达式简化策略定义

```java
public class LambdaStrategyDemo {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie", "David"};

        // 使用Lambda表达式定义策略
        Arrays.sort(names, (a, b) -> b.length() - a.length()); // 按长度降序
        System.out.println("按长度降序: " + Arrays.toString(names));

        Arrays.sort(names, String::compareToIgnoreCase); // 忽略大小写排序
        System.out.println("忽略大小写: " + Arrays.toString(names));

        // 组合策略：先按长度，再按字典序
        Arrays.sort(names, Comparator
            .comparingInt(String::length)
            .thenComparing(String::compareToIgnoreCase));
        System.out.println("复合策略: " + Arrays.toString(names));
    }
}
```

## 策略模式在JDK中的优势

### 1. **算法族封装**
- 不同的排序策略被封装在独立的 `Comparator` 实现中
- 策略之间相互独立，互不影响
- 可以轻松添加新的排序策略而无需修改现有代码

### 2. **运行时选择**
- 可以在运行时根据需要选择不同的排序策略
- 支持动态切换排序算法
- 提高了程序的灵活性

### 3. **职责分离**
- `Arrays` 类专注于排序算法的实现
- `Comparator` 接口专注于比较逻辑的定义
- 降低了类之间的耦合度

### 4. **符合开闭原则**
- 对扩展开放：可以添加新的比较策略
- 对修改关闭：不需要修改 `Arrays` 类的代码

## 与我们自己实现的策略模式对比

| 对比项 | Arrays.sort() | 我们的图书折扣系统 |
|--------|---------------|-------------------|
| **环境角色** | Arrays类 | Book类 |
| **策略接口** | Comparator<T> | DiscountStrategy |
| **具体策略** | 各种Comparator实现 | ComputerBookDiscountStrategy等 |
| **策略传递** | 方法参数传递 | 构造函数注入 |
| **调用方式** | Arrays.sort(array, comparator) | book.getFinalPrice() |
| **业务场景** | 排序算法 | 折扣计算 |

## 学习要点

1. **策略识别**: `Comparator` 接口就是抽象策略角色
2. **策略使用**: `TimSort.sort()` 方法中通过 `c.compare()` 调用策略
3. **策略传递**: 通过方法参数传递策略对象
4. **策略切换**: 同一个数组可以使用不同的策略进行排序
5. **扩展性**: 用户可以自定义任意复杂的排序策略

## 总结

JDK中的 `Arrays.sort()` 方法是策略模式的经典实现：

- **策略接口**: `Comparator` 定义了比较的统一接口
- **具体策略**: 用户提供的各种比较器实现
- **上下文角色**: `Arrays` 类使用策略进行排序
- **策略应用**: `TimSort` 类中的 `compare()` 调用

这种设计使得排序算法的实现与比较逻辑的定义完全分离，极大地提高了代码的灵活性和可扩展性。我们可以根据需要提供任意的比较策略，而排序算法本身保持不变。

这正是策略模式的核心价值：**定义一系列算法，把它们一个个封装起来，并且使它们可相互替换**。