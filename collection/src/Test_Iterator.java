import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test_Iterator {

    public static void main(String[] args) {

        Iterator<String> stringIterator = new Iterator<String>() {
            @Override
            public boolean hasNext() {//有没有下一个
                return false;
            }

            @Override
            public String next() {//拿到下一个
                return null;
            }

            @Override
            public void remove() {//删除，需要独立实现

            }
        };


        List<Integer> i = new LinkedList<Integer>(){
            @Override
            public boolean add(Integer integer) {
                return super.add(integer+1);
            }
        };
        i.add(1);
        i.add(2);
        i.add(3);
        i.add(4);
        Iterator<Integer> iterator = i.iterator();
        //迭代遍历
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
