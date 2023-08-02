import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Tess_Thread_Safe {

    public static void main(String[] args) {
        //都是线程安全的
        List<Integer> list = new Vector<>();
        Hashtable<Integer, Integer> integerIntegerHashtable = new Hashtable<>();
        CopyOnWriteArrayList<Integer> integers = new CopyOnWriteArrayList<>();//写时复制：读时不加锁，写时加锁，写完后改变引用。原来的数据被垃圾回收

        //1.7是头插(在扩容的时候会rehash打乱，还会形成循环链表(指针倒换)，不如用尾插)，
        // 1.8是尾插。在tab加锁(锁表头)
        ConcurrentHashMap<Integer, Integer> integerIntegerConcurrentHashMap = new ConcurrentHashMap<>();
    }
}
