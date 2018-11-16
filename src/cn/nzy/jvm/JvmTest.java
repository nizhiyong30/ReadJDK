package cn.nzy.jvm;

import cn.nzy.AnnonationStudy.Apple;

/**
 * Created by nizy on 2018/10/23.
 */
public class JvmTest {

     Integer i = 127;

    public static void main(String[] args) {
        new JvmTest().test();
    }

    public void test () {
        Integer j = 127;
        System.out.println(i == j);
    }

}
