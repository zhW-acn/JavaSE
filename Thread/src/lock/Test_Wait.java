package lock;

import Deamon.ThreadUtils;

public class Test_Wait {
    public static final Object MONITOR = new Object();

    public static void main(String[] args) {
        new Thread(()-> {
            synchronized (MONITOR){
                System.out.println("线程1开始了");
                try {
                    MONITOR.wait();//释放锁
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程1结束了");
            }
        },"1").start();


        new Thread(()-> {
            synchronized (MONITOR){
                ThreadUtils.sleep(100);
                System.out.println("线程2开始了");
                MONITOR.notify();//唤醒锁
                System.out.println("线程2结束了");
            }
        },"2").start();
    }

}
