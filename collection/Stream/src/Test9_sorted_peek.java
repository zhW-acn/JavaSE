import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test9_sorted_peek {
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
    public void sortTest(){
        personList.stream().sorted((p1,p2)->p2.getSalary()-p1.getSalary()).forEach(System.out::println);
    }

    @Test
    public void peekTest(){
        // 在stream中间进行调试，因为stream不支持debug
        List<Person> collect = personList.stream().filter(p -> p.getSalary() > 5000)
                .peek(System.out::println).collect(Collectors.toList());
        // 修改元素的信息，给每个员工涨工资一千
        personList.stream().peek(p -> p.setSalary(p.getSalary() + 1000))
                .forEach(System.out::println);
    }
}
