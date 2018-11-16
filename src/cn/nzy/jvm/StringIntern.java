package cn.nzy.jvm;

/**
 * Created by nizy on 2018/10/23.
 */
public class StringIntern {
    public static void main(String[] args) {
        String s1 = new StringBuilder("倪智勇点点滴滴").append("那是").toString();
        System.out.println(s1);
        System.out.println(s1.intern());
        System.out.println(s1.intern() == s1);
    }

    public void test() {
        final int i = 1;
    }
}
