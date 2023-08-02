import java.util.*;

public class Test_Map {
    //Map 保存的是键值对，键要求保持唯一性，值可以重复。
    public static void main(String[] args) {
        //HashMap 实现了 Map 接口，可以根据键快速地查找对应的值——通过哈希函数将键映射到哈希表中的一个索引位置，从而实现快速访问。
        Map<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(1, 1);

        //如何遍历：第二种效率高，因为第一种每次get(key)之后还会在map里再找一遍。第二种是直接遍历一次map后放到entrySet里，只需遍历entrySet里的即可
        //1
        Set<Integer> integers = hashmap.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println("key = " + key);
            System.out.println("value = " + hashmap.get(key));
        }

        //2
        Set<Map.Entry<Integer, Integer>> entries = hashmap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator1 = entries.iterator();

        while (iterator1.hasNext()) {//错误做法，一次循环里调了两次next
            System.out.println("key = " + iterator1.next().getKey());
            System.out.println("value = " + iterator1.next().getValue());
        }

        while (iterator1.hasNext()) {//正确的
            Map.Entry<Integer, Integer> next = iterator1.next();
            System.out.println("key = " + next.getKey());
            System.out.println("value = " + next.getValue());
        }


        //与hashmap不同的是，在插入时维护了链表保证有序。同时又比LinkedList的查询效率高
        Map<String, String> stringLinkedHashMap = new LinkedHashMap<>();


        //实现了SortedMap 接口，可以自动将键按照自然顺序或指定的比较器顺序排序，并保证其元素的顺序。
        // 内部使用红黑树来实现键的排序和查找。
        // 与 HashMap 不同的是，TreeMap 会按照键的顺序来进行排序。
        Map<String, String> stringStringTreeMap = new TreeMap<>();


    }

}
