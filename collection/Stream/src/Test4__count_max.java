import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test4__count_max {

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
}
