package pool;

import Deamon.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test_ThreadPool {//定长线程池，可控制线程最大并发数，超出的线程在队列中等待
    /*
    无论是哪一个都是调用ThreadPoolExecutor 构造方法：
    public ThreadPoolExecutor(int corePoolSize,  指定了线程池里的线程数量，核心线程池大小
              int maximumPoolSize,               指定了线程池里的最大线程数量
              long keepAliveTime,                当线程池线程数量大于corePoolSize时候，多出来的空闲线程，多长时间会被销毁
              TimeUnit unit,                     时间单位，TimeUnit
              BlockingQueue<Runnable> workQueue, 任务队列，用于存放提交但是尚未被执行的任务  分有界和无界队列
              ThreadFactory threadFactory,       线程工厂，用于创建线程
              RejectedExecutionHandler handler)  拒绝策略，将任务添加到线程池中时，线程池拒绝该任务所采取的相应策略
     */

    public static void main(String[] args) {
        ExecutorService Fixed = Executors.newFixedThreadPool(5);//初始化只有5个线程
        ExecutorService Single = Executors.newSingleThreadExecutor();//相比Fixed这个线程池只有一个线程
        ExecutorService Cache = Executors.newCachedThreadPool();//可缓存线程池，灵活回收和新建线程，根据线程数确定线程数量
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("--------");
                ThreadUtils.sleep(2000);
            }
        };

        //submit可以传Runnable(无返回值)和Callable(有返回值)
        for (int i = 0; i < 50; i++) {
//            Fixed.submit(task);//一次五个执行
//            Single.submit(task);//一次一个执行

        }
    }
}
