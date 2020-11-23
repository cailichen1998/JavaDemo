package com.cailichen.java;

import java.math.BigDecimal;

/**
 * @author cailichen
 * @create 2020-11-19 14:41
 */
public class Number {
    //Integer为int的包装类型，采用包装类型可以使用很多包装类的方法
    Integer a = new Integer(8);
    Integer b = 2;

    //BigDecimal可以对浮点数进行精确的操作
    BigDecimal bd = new BigDecimal(3.1415926);//给bd赋值π
    BigDecimal bd2 = bd.multiply(bd);//计算π乘π的值

    //全局变量定义可以不赋初值,系统默认赋值0或null
    static String str="Hello";
    String str2;
    static int t;





    public static void main(String[] args) {
        Number n = new Number();
        int c = n.a.compareTo(n.b);  //判断a与b的比较结果，若a比b大返回1；
        boolean isEqual = n.b.equals(n.a);//判断a与b是否相等，返回Boolean类型值

        System.out.println(n.bd2);//打印计算后的值

        char ar = str.charAt(2);
        boolean isEqual2 = str.equals("Hello");
        System.out.println(t);
        System.out.println(new Number().str2);



    }
}
