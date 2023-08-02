public class Test_ThreadLocal {

    /* 这个方式每个线程取到的num都是单独的 */
//    private static int num = 0;
//
//    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                System.out.println("t1-----" + num++);
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                System.out.println("t2-----" + num++);
//            }
//        });
//        t2.start();
//        t1.start();

    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();// 维护本地(主线程)的变量的值，相当于一个管理者
    // 其他线程要想单独使用被维护变量要用get和set方法，实现了线程安全(数据不可变)
    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            threadLocal.set(num);
            for (int i = 0; i < 100; i++) {
                threadLocal.set(threadLocal.get() + 1);
                System.out.println("t1-----" + threadLocal.get());
            }
        });

        Thread t2 = new Thread(() -> {
            threadLocal.set(num);
            for (int i = 0; i < 100; i++) {
                threadLocal.set(threadLocal.get() + 1);
                System.out.println("t1-----" + threadLocal.get());
            }
        });
        System.out.println(num);
        t1.start();
        t2.start();
        Thread.sleep(5000);
        System.out.println(num);
    }
}
