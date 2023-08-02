import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class arrayList_LinkedList_Test {

    @Test
    public void testArrayListAdd(){
        List<Integer> list = new ArrayList<>();
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*100));
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
    }

    @Test
    public void testLinkedListAdd(){
        List<Integer> list = new LinkedList<>();
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*100));
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
    }
}
