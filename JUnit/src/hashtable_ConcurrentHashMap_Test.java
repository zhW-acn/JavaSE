import org.junit.jupiter.api.Test;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class hashtable_ConcurrentHashMap_Test {
    @Test
    public void hashtableTest() throws InterruptedException {
        final Map<Integer,Integer> map = new Hashtable<>(500000);
        final CountDownLatch countDownLatch = new CountDownLatch(50);
        System.out.println("----------------开始测试Hashtable------------------");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            int j = i;
            new Thread(()->{
                for (int k = 0; k < 100000; k++) {
                    map.put(j*k,1);
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("hashtable:(end-start) = " + (end - start));

        // ----------------开始测试ConcurrentHashMap------------------
        System.out.println("----------------开始测试ConcurrentHashMap------------------");
        final Map map2 = new ConcurrentHashMap<>(500000);
        final CountDownLatch countDownLatch2 = new CountDownLatch(50);
        start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            int j = i;
            new Thread(()->{
                for (int k = 0; k < 100000; k++) {
                    map2.put(j*k,1);
                }
                countDownLatch2.countDown();
            }).start();
        }
        countDownLatch.await();
        end = System.currentTimeMillis();
        System.out.println("ConcurrentHashMap:(end-start) = " + (end - start));
    }
}
