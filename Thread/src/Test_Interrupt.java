import Deamon.ThreadUtils;


/*
如果线程处于被阻塞状态（例如处于sleep, wait, join 等状态），那么线程将立即退出被阻塞状态，并抛出一个InterruptedException异常。
如果线程处于正常活动状态，那么会将该线程的中断标志设置为 true。被设置中断标志的线程将继续正常运行，不受影响。
 */

public class Test_Interrupt {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("begin");
            try {
                Thread.sleep(19999999);
            } catch (InterruptedException e) {
                System.out.println("我被打断了");
                throw new RuntimeException(e);
            }
            System.out.println("end");
        });

        thread.start();
        ThreadUtils.sleep(2000);
        thread.interrupt();
    }
}
