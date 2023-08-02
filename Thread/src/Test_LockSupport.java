import Deamon.ThreadUtils;


//这是个工具类，park()可以在任意位置阻塞线程，唤醒线程要unpark(),里面传入要唤醒的线程
import java.util.concurrent.locks.LockSupport;

public class Test_LockSupport {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(1);
            ThreadUtils.sleep(100);
            System.out.println(2);
            LockSupport.park();
            System.out.println(3);
        });

        thread.start();
        ThreadUtils.sleep(1000);
        System.out.println("1s过去了");
        LockSupport.unpark(thread);
    }
}
