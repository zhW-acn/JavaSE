package Deamon;

public class ThreadUtils {
    public static void sleep(long sleeptime) {
        try {
            Thread.sleep(sleeptime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
