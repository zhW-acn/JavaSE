package Deamon;

public class Deamon {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Thread t2 = new Thread(() -> {
                while (true){
                    ThreadUtils.sleep(300);
                    System.out.println("我是个守护线程！");
                }
            });
            t2.setDaemon(true);
            t2.start();

            int count = 10;
            while (count >= 0){
                ThreadUtils.sleep(200);
                System.out.println("我是用户线程！");
                count--;
            }
            System.out.println("用户线程结束-------------------");
        });
        //t1.setDaemon(true);
        t1.start();
    }
}