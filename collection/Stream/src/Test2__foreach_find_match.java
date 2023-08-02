import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test2__foreach_find_match {
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

    @Test//遍历&匹配
    public void foreachTest() {
        personList.stream().forEach(System.out::println);//personList.stream().forEach(person->System.out.println(person));
    }

    @Test
    public void findTest() {
        //单线程
        Optional<Integer> first = simpleList.stream().findFirst();//拿到第一个
        first.ifPresent(System.out::println);
        Optional<Integer> any = simpleList.stream().findAny();//随便拿一个
        any.ifPresent(System.out::println);

        //多线程
        Optional<Integer> first1 = simpleList.parallelStream().findFirst();
        first1.ifPresent(System.out::println);
        Optional<Integer> any1 = simpleList.parallelStream().findAny();
        any1.ifPresent(System.out::println);
    }

    @Test
    public void matchTest() {
        //是否所有人工资都大于5000
        boolean flag = personList.stream().allMatch(p -> p.getSalary() > 5000);//拿到第一个
        System.out.println(flag);
        //是否有人工资大于5000
        boolean flag1 = personList.stream().anyMatch(p -> p.getSalary() > 5000);//拿到第一个
        System.out.println(flag1);
    }
}
