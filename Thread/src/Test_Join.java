import Deamon.ThreadUtils;

public class Test_Join {//插队执行
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            ThreadUtils.sleep(2000);
            System.out.println("=====t1======");
        });

        Thread t2 = new Thread(()->{
            ThreadUtils.sleep(3000);
            System.out.println("=====t2======");
        });

        t1.start();
        t2.start();

        try {
            t1.join();//等待t1执行(插队)
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("====main=====");
    }
}
