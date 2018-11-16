package cn.nzy.Thread;

/**
 * Created by nizy on 2018/7/12.
 */
public class RunnableUtil implements Runnable{
    public void run() {
        System.out.println("thread");

    }

    public static void main(String[] args) {
        new Thread(new RunnableUtil()).start();
    }
}
