package cn.nzy.test;

/**
 * Created by nizy on 2018/10/16.
 */
public class TestClass {

    private int m;

    static private int n;

    public int inc() {
        return m+1;
    }

    synchronized  public int des() {
        return m-1;
    }

    public int test() {
        synchronized (this) {
            return m++;
        }
    }
}
