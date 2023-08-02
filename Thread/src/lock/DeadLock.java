package lock;

import Deamon.ThreadUtils;

public class DeadLock {
    /*
    互斥使用:资源只此一份
    不可抢占:只能资源占有者主动释放
    请求保持:请求其他资源同时保留自己已有的资源
    循环等待:形成等待环路
     */
    public static final Object MONITOR1 = new Object();
    public static final Object MONITOR2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (MONITOR1) {
                System.out.println(Thread.currentThread().getName() + "获取一号");
                ThreadUtils.sleep(100);
                synchronized (MONITOR2) {
                    System.out.println(Thread.currentThread().getName() + "获取二号");
                }
            }
        }, "Thread1").start();
        new Thread(() -> {
            synchronized (MONITOR2) {
                System.out.println(Thread.currentThread().getName() + "获取二号");
                ThreadUtils.sleep(100);
                synchronized (MONITOR1) {
                    System.out.println(Thread.currentThread().getName() + "获取一号");
                }
            }
        }, "Thread2").start();
    }
}
