import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test8_map {
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

    @Test
    public void mapTest() {
        List<Integer> collect = personList.stream().map(p -> p.getSalary()).collect(Collectors.toList());//只保存工资信息的集合
        System.out.println(collect);

        personList.stream().map(p-> {//加工资
            p.setSalary(p.getSalary()+1000);
            return p;
        }).forEach(System.out::println);
    }

}
