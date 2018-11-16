package cn.nzy.jvm;

/**
 * Created by nizy on 2018/10/30.
 */
public class OOMTest {

    public static String obj1 = "obj1";
    public static String obj2 = "obj2";

    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ;
                }
            }
        }, "testBusyThread");
        thread.start();
    }

    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    static class Lock1 implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Lock1 running");
                while (true) {
                    synchronized (OOMTest.obj1) {
                        System.out.println("Lock1 lock obj1");
                        Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
                        synchronized (OOMTest.obj2) {
                            System.out.println("Lock1 lock obj2");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class Lock2 implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Lock2 running");
                while (true) {
                    synchronized (OOMTest.obj2) {
                        System.out.println("Lock2 lock obj2");
                        Thread.sleep(3000);
                        synchronized (OOMTest.obj1) {
                            System.out.println("Lock2 lock obj1");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
//        createBusyThread();
//        br.readLine();
//        Object obj = new Object();
//        createLockThread(obj);

        Thread a = new Thread(new Lock1(),"nzy-1");
        Thread b = new Thread(new Lock2(),"nzy-2");
        a.start();
        b.start();
    }
}
