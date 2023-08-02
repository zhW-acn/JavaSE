package DesignMode;

public class Hungry {//饿汉式

    // 立即加载就是使用类的时候已经将对象创建完毕
    // （不管以后会不会使用到该实例化对象，先创建了再说。
    // 常见的实现办法就是直接new实例化。
    //只初试化一个


    private static final Hungry INSTANCE = new Hungry();

    //让别人不能new
    private Hungry() {

    }

    //保证别人能获取
    public static Hungry getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Hungry instance1 = Hungry.getInstance();
        Hungry instance2 = Hungry.getInstance();
        Hungry instance3 = Hungry.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance3 == instance2);
        //两个都是true，说明内存地址一样，拿的是同一份实例
    }
}

