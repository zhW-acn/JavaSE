package creatThread;

public class UseRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(2);
    }

    public static void main(String[] args) {
        System.out.println(1);
        new Thread(new UseRunnable()).start();//UseRunnable作为Target参数传入Thread里，再用Thread的start()方法启动
        System.out.println(3);

        //或者用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(4);
            }
        }).start();

        //再次简化为Lambda表达式
        new Thread(() -> System.out.println(5)).start();
    }
}
