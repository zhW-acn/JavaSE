package creatThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UseCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<Integer> futureTask = new FutureTask<>(new UseCallable());
//        new Thread(futureTask).start();
//        Integer integer = futureTask.get();// 使主线程阻塞，等待get()返回值
//        System.out.println(integer);
        //总结：FutureTask需要传入一个Callable子类，将f给Thread.start()启动，再用f.get()获得Callable子类重写的call()返回值
        System.out.println(2);
        FutureTask<Integer> futureTask = new FutureTask<>(new UseCallable());
        System.out.println(3);
        new Thread(futureTask).start();
        System.out.println(4);
        //类似Scanner的nextInt()
        int result = futureTask.get();
        System.out.println(5);
        System.out.println(result);
        System.out.println(6);
    }
}
