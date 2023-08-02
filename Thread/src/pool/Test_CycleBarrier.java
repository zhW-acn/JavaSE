package pool;

import Deamon.ThreadUtils;

import java.util.Random;
import java.util.concurrent.*;

public class Test_CycleBarrier {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        Runnable last = () -> System.out.println("last");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, last);//当parties = 0 时才能执行last

        Runnable task1 = () -> {
            ThreadUtils.sleep(new Random().nextInt(5000));
            System.out.println("1");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable task2 = () -> {
            ThreadUtils.sleep(new Random().nextInt(5000));
            System.out.println("2");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable task3 = () -> {
            ThreadUtils.sleep(new Random().nextInt(5000));
            System.out.println("3");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };

        pool.submit(task1);
        pool.submit(task2);
        pool.submit(task3);

        cyclicBarrier.reset();//相比较CountDownLatch可以重复使用

        pool.submit(task1);
        pool.submit(task2);
        pool.submit(task3);
        pool.shutdown();
    }
}
