import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Test3__toList_toSet_toMap {
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

    @Test////归集
    public void collectTest() {
        // 判断有没有任意一个人年龄大于35岁
        List<Integer> collect = simpleList.stream().collect(Collectors.toList());
        System.out.println(collect);
        Set<Integer> collectSet = simpleList.stream().collect(Collectors.toSet());
        System.out.println(collectSet);
        Map<String, Person> collect1 = personList.stream().collect(Collectors.toMap(p -> p.getName(), p -> p));
        System.out.println(collect1);
    }

}
