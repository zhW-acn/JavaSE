import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test6__group {
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
    @Test//分组(partitioningBy/groupingBy)
    /**
     * 分区：将stream按条件分为两个Map，比如员工按薪资是否高于5000分为两部分。
     * 分组：将集合分为多个Map，比如员工按性别分组。
     */
    public void groupTest() {
        Map<Boolean, List<Person>> collect = personList.stream().collect(Collectors.partitioningBy(p -> p.getSalary() > 5000));
        System.out.println(collect);

        Map<String, List<Person>> collect1 = personList.stream().collect(Collectors.groupingBy(p -> p.getSex()));
        System.out.println(collect1.get("男"));
    }

}
