package cn.nzy.test;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by nizy on 2018/7/23.
 */
public class Test {

    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        System.out.println("Singleton1 value1:" + singleton1.value1);
        System.out.println("Singleton1 value2:" + singleton1.value2);

        Singleton2 singleton2 = Singleton2.getInstance2();
        System.out.println("Singleton2 value1:" + singleton2.value1);
        System.out.println("Singleton2 value2:" + singleton2.value2);
    }

}

class Singleton1{
    private static Singleton1 singleton = new Singleton1();
    public static int value1;
    public static int value2 = 0;

    private Singleton1(){
        value1++;
        value2++;
    }

    public static Singleton1 getInstance(){
        return singleton;
    }

}


class Singleton2{
    public static int value1;
    public static int value2 = 0;
    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2(){
        value1++;
        value2++;
    }

    public static Singleton2 getInstance2(){
        return singleton2;
    }
}

