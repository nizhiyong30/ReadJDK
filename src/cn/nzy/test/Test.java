package cn.nzy.test;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by nizy on 2018/7/23.
 */
public class Test {

    private static Integer index = 0;

    public static void main(String[] args) {
        String s = "@=1-2-3-4-5";

        String s1 = s.substring(0, s.indexOf("=")+1);

        StringBuilder sb = new StringBuilder(s1).append("test");

        System.out.println(sb.toString());

        List<String> list = new ArrayList<>(1);



    }


}
