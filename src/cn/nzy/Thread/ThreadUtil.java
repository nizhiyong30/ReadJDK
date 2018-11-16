package cn.nzy.Thread;

/**
 * Created by nizy on 2018/7/12.
 */
public class ThreadUtil extends Thread{
    @Override
    public void run() {
        System.out.println("thread");

    }

    public static void main(String[] args) {
        Thread thread = new ThreadUtil();
        thread.start();
    }

}
