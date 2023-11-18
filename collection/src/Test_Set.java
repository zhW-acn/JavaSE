import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Set 的特点是存取无序，不可以存放重复的元素，不可以用下标对元素进行操作
 */
public class Test_Set {

    public static void main(String[] args) {
        //如果有去重需求且对数据排序没有要求可以用HashSet中转
        HashSet<String> strings = new HashSet<>();//HashSet 由 HashMap 实现的，只不过值由一个固定的 Object 对象填充，而键用于操作。

        //LinkedHashSet是
        // 一种基于哈希表实现的Set接口，它继承自HashSet，并且使用链表维护了元素的插入顺序。
        // 因此，它既具有HashSet的快速查找、插入和删除操作的优点，又可以维护元素的插入顺序。
        LinkedHashSet<String> strings1 = new LinkedHashSet<String>();

        //与 TreeMap 相似，TreeSet 是一种基于红黑树实现的有序集合，它实现了 SortedSet 接口，
        // 可以自动对集合中的元素进行排序。按照键的自然顺序或指定的比较器顺序进行排序。
        //TreeSet 不允许插入 null 元素，否则会抛出 NullPointerException 异常。
        TreeSet<Integer> ints = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        ints.add(1);
        ints.add(2);
        ints.add(3);
        for (Integer anInt : ints) {
            System.out.println(anInt);
        }
        System.out.println(ints.size());

    }
}
