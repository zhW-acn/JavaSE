package DesignMode;

public class StaticInner {//内部类

    // 这种也是懒汉式的一种实现，而且使用这种懒汉式没有任何的线程问题，
    // 大家来思考，结合咱们上边的内容，只要不调用getInstance()方法，就不会使用内部类，
    // 内部类一旦被使用，只会被初始化一次，以后一直用的就是静态常量 INSTANCE 了


    //私有构造器
    private StaticInner() {
    }

    //对外提供公共的访问方法，获取实例
    public static StaticInner getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //静态内部类会在第一次使用的时候加载一次，静态常量会在类加载后初始化，在内存只有唯一一份实例
    private static class SingletonHolder {
        private static final StaticInner INSTANCE = new StaticInner();
    }

    public static void main(String[] args) {
        StaticInner staticInner1 = StaticInner.getInstance();
        StaticInner staticInner2 = StaticInner.getInstance();
        StaticInner staticInner3 = StaticInner.getInstance();
        System.out.println(staticInner1 == staticInner2);
        System.out.println(staticInner3 == staticInner2);
    }
}