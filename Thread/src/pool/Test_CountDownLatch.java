package pool;

import Deamon.ThreadUtils;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test_CountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(3);//count = 3

        Runnable task1 = () ->{
            ThreadUtils.sleep(new Random().nextInt(5000));
            System.out.println("1");
            countDownLatch.countDown();//count--
        };
        Runnable task2 = () ->{
            ThreadUtils.sleep(new Random().nextInt(5000));
            System.out.println("2");
            countDownLatch.countDown();
        };
        Runnable task3 = () ->{
            ThreadUtils.sleep(new Random().nextInt(5000));
            System.out.println("3");
            countDownLatch.countDown();
        };

        pool.submit(task1);
        pool.submit(task2);
        pool.submit(task3);
        countDownLatch.await();//阻塞，直到count = 0 才执行后面的代码
        System.out.println("4");

        pool.shutdown();
    }
}
