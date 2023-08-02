import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test5__reduce_join {
    List<Person> personList = new ArrayList<Person>();
    List<Integer> simpleList = Arrays.asList(15, 22, 9, 11, 33, 52, 14);

    @Before
    public void initData() {
        personList.add(new Person("张三", 3000, 23, "男", "太原"));
        personList.add(new Person("李四", 7000, 34, "男", "西安"));
        personList.add(new Person("王五", 5200, 22, "女", "太原"));
        personList.add(new Person("小黑", 1500, 33, "女", "上海"));
        personList.add(new Person("狗子", 8000, 44, "女", "北京"));
        personList.add(new Person("铁蛋", 6200, 36, "女", "南京"));
    }

    @Test//归约(reduce)
    public void reduceTest() {
        int reduce = IntStream.of(2, 1, 3, 4).reduce(1, (n1, n2) -> n1 * n2);// n1*n2的结果赋给n1,identity是初始值
        System.out.println(reduce);
        int reduce1 = IntStream.of(2, 1, 3, 4).reduce(0, (n1, n2) -> n1 + n2);// n1+n2的结果赋给n1
        System.out.println(reduce1);

    }

    @Test
    public void joiningTest() {
        List<String> list = Arrays.asList("A", "B", "C");
        String string = list.stream().collect(Collectors.joining("-"));
        System.out.println("拼接后的字符串：" + string);
    }

}
