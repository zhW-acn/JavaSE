package pool;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class myThreadPool  {
    /*
    FixedThreadPool、SingleThreadExecutor可能会堆积大量请求，OOM
    CachedThreadPool、newSingleThreadExecutor可能会创建大量线程，OOM
     */

    public static void main(String[] args) {
        //自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(50),
                new ThreadFactory() {//匿名内部类重写线程工厂
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                },
                (r,executor)->{
                    System.out.println("自定义拒绝策略");
                });

        for (int i = 0; i < 600; i++) {
            threadPoolExecutor.submit(()->{
                System.out.println("----");
            });
        }

        threadPoolExecutor.shutdown();//线程池不会自动销毁
    }
}
