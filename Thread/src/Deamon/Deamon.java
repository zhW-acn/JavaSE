package Deamon;

public class Deamon {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int count = 10;
            while (count >= 0){
                ThreadUtils.sleep(200);
                System.out.println("我是用户线程！");
                count--;
            }
            System.out.println("用户线程结束-------------------");
        });

        Thread t2 = new Thread(() -> {
            while (true){
                ThreadUtils.sleep(300);
                System.out.println("我是个守护线程！");
            }
        });
        t2.setDaemon(true);
        t2.start();
//        t1.setDaemon(true);
        t1.start();

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Main thread is running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Main thread is done.");
    }
}