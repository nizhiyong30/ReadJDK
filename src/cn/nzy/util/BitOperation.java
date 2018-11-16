package cn.nzy.util;

/**
 * Created by nizy on 2018/7/12.
 */
public class BitOperation {
    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY = (1 << COUNT_BITS) - 1;
        System.out.println(((-1 << COUNT_BITS) & (CAPACITY)));
        System.out.println(0<<COUNT_BITS);

    }
}
