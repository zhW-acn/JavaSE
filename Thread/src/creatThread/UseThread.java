package creatThread;

public class UseThread extends Thread {
    @Override
    public void run() {
        System.out.println(2);
    }

    public static void main(String[] args) {
        System.out.println(1);
        new UseThread().start();// 用run()只是调用方法，start()才是启动线程的方式
        System.out.println(3);
    }
}
