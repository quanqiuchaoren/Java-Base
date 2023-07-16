package com.lhy.java.base.constructor;

import org.junit.jupiter.api.Test;

public class InitialOrderTest {
    /**
     * 执行顺序：
     * 1.静态代码块。（执行一次）
     * 2.代码块。（执行多次）
     * 3.构造函数。（执行多次）
     * 输出结果：
     * --------------- static code block
     * --------------- code block
     * --------------- MyOrder()构造函数
     * --------------- code block
     * --------------- MyOrder()构造函数
     */
    @Test
    void testOrder() {
        new MyOrder();
        new MyOrder();
    }

}


class MyOrder {
    static {
        System.out.println("--------------- static code block");
    }

    {
        System.out.println("--------------- code block");
    }

    MyOrder() {
        System.out.println("--------------- MyOrder()构造函数");
    }
}