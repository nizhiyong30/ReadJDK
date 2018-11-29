package cn.nzy.jvm.MemoryLeakAnalysize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiyong on 2018/11/29.
 */
public class StaticTest {

    public static List<Double> list = new ArrayList<>();

    public void pupulateList() {
        for (int i = 0; i < 10000000; i++) {
            list.add(Math.random());
        }
        System.out.println("Debug Point 2");
    }

    public static void main(String[] args) {
        System.out.println("Debug Point 1");
        new StaticTest().pupulateList();
        System.out.println("Debug Point 2");
    }


}
