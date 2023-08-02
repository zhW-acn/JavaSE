package preStudy;

public class FunctionInterface {

    @FunctionalInterface
    public interface Consumer<T> {//消费者，消费数据

        void accept(T t);
    }

    @FunctionalInterface
    public interface Supplier<T> {//供应商，给我们产生数据

        T get();
    }

    @FunctionalInterface
    public interface Predicate<T> {//断言，判断传入的t是不是满足条件

        boolean test(T t);
    }

    @FunctionalInterface
    public interface Function<T, R> {//函数，就是将一个数据转化成另一个数据

        R apply(T t);
    }

    public static void main(String[] args) {

        Supplier<String> stringSupplier = () -> "提供";
        System.out.println(stringSupplier.get());

        Consumer<String> consumer = c -> System.out.println(c);
        consumer.accept("aaa");

        Predicate<Integer> predicate = integer -> integer > 0;
        System.out.println(predicate.test(3));

        Function<String, String> function = s -> s.toUpperCase();
        System.out.println(function.apply("aaa"));
    }
}
