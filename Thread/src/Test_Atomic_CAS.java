import Deamon.ThreadUtils;

import java.util.concurrent.atomic.AtomicInteger;

public class Test_Atomic_CAS {

    AtomicInteger atomicInteger = new AtomicInteger();//有专门的工具类
    public static volatile int COUNT;

    /**
     * compare and set,比较后设置，，必须要保证原子性---
     * 有缺点：1.ABA问题(尚未修改新值之前，内存中的值已经被其他线程连续修改了两次)，解决方案：添加版本号作为标识，每次修改值之前对应增加版本号
     * 2.如果自旋时间长，会增大CPU执行开销
     * 3.只能对一个变量进行原子操作
     */

    /**
     * AbstractQueuedSynchronizer抽象队列同步器
     * 步骤：线程获取锁，如果得到了就执行代码块，执行完毕释放锁并唤醒线程队列的头结点
     * 如果未得到锁就尝试自旋，自旋一段时间还未得到就进入队列，等待被唤醒
     */

    public static synchronized boolean cas(int expect, int update) {
        if (COUNT == expect) {//count和期望值比较(期望count不变)
            COUNT = update;//如果不变，把更新值赋给count
            return false;//退出while
        }
        return true;//继续自旋
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                ThreadUtils.sleep(10);

//                COUNT++;//volatile保证不了原子性

                /*
                synchronized (ThreadUtils.class) {//用锁
                    COUNT++;
                }
                 */

                while (cas(COUNT, COUNT + 1)) ;//自旋

            }).start();
        }

        ThreadUtils.sleep(3000);
        System.out.println(COUNT);
    }
}
