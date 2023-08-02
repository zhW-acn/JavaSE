import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test_List {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();//基于数组
        LinkedList<String> list1 = new LinkedList<>();//基于链表
        //也可以这样写
        List<String> list2 = new LinkedList<>();//父类引用指向子类对象
/**
 * Vector 和 Stack
 * List 的实现类还有一个 Vector，比 ArrayList 出现得更早。
 * ArrayList 和 Vector 非常相似，Vector 是线程安全的，加了 synchronized 关键字，效率低
 *
 * Stack 是 Vector 的一个子类，本质上也是由动态数组实现的
 * 只不过还实现了先进后出的功能
 * （在 get、set、add 方法的基础上追加了 pop「返回并移除栈顶的元素」、peek「只返回栈顶元素」等方法）
 */
    }
}
