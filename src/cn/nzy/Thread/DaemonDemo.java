package cn.nzy.Thread;

/**
 * Created by nizy on 2018/10/31.
 */
public class DaemonDemo {

    public static class Daemon extends Thread {

        @Override
        public void run () {
            while(true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Daemon();
//        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
