package cn.nzy.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by nizy on 2019/3/15.
 */
public class SDFUtil {


    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 使用ThreadFactoryBuilder定义一个线程池
     */
//    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    private static ExecutorService pool = new ThreadPoolExecutor(5, 200, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.AbortPolicy());
    private static CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) {
        Set<String> dates = Collections.synchronizedSet(new HashSet<String>());
        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            int finalI = i;
            pool.execute(() -> {
                calendar.add(Calendar.DATE, finalI);
                String dateString = simpleDateFormat.format(calendar.getTime());
                dates.add(dateString);
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(dates.size());
    }


}
