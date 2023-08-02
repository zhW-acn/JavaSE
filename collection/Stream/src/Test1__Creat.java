import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1__Creat {

    public static void main(String[] args) {
        //使用集合
        List<String> l =  new ArrayList<>();
        Stream<String> stringStream = l.stream();

        //使用Arrays
        String[] array ={"1","2","3"};
        Stream<String> integerStream = Arrays.stream(array);

        //Stream的静态方法
        Stream<String> concat = Stream.concat(stringStream,integerStream);
        Stream<String> a = Stream.of("a","b");
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(4);
        stream2.forEach(System.out::println);
        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
        stream3.forEach(System.out::println);

        //Random
        IntStream ints = new Random().ints(100);
    }
}
