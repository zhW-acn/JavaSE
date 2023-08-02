package DesignMode;

public class ArrowFunction {
    @FunctionalInterface
    public interface Function {

        int plus(int i, int j);
    }

    public static void test(Function f) {
        System.out.println("f.plus(5,2) = " + f.plus(5, 2));
    }

    public static void main(String[] args) {
//        Function f = new Function() {//匿名内部类
//            @Override
//            public int plus(int i, int j) {
//                return i + j;
//            }
//        };语法糖

        Function f = (i, j) -> i + j;

        System.out.println(f.plus(1, 2));
        System.out.println(f.plus(5, 2));

        test((i, j) -> i * j);
    }
}


