package cn.nzy.Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by nizy on 2018/11/19.
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    final static long THRESHOLD_VALUE = 10;

    private long start;

    private long end;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Long compute() {
        boolean flag = (end - start) > 10 ? false : true;
        if (flag) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (end + start) / 2;
            ForkJoinDemo leftForkJoinDemo = new ForkJoinDemo(start, middle);
            ForkJoinDemo rightForkJoinDemo = new ForkJoinDemo(middle + 1, end);
            leftForkJoinDemo.fork();
            rightForkJoinDemo.fork();
            return leftForkJoinDemo.join() + rightForkJoinDemo.join();
        }

    }


    public static void main(String[] args) {
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(0, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> result = forkJoinPool.submit(forkJoinDemo);
        try {
            long sum = result.get();
            System.out.println(sum);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
