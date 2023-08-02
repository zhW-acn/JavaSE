package pool;

import Deamon.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Test_Semaphore {

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(5);//最多五个线程获得信号量
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 50; i++) {
            Runnable run = () -> {
                try {
                    semaphore.acquire();//获得信号量
                    System.out.println("成功获得信号量");
                    ThreadUtils.sleep((long) (Math.random() * 5000));
                    semaphore.release();//释放信号量
                    System.out.println("释放信号量");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };

            executorService.execute(run);
        }
        executorService.shutdown();
    }
}
