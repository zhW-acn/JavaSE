package DesignMode;

public class lazy {//懒汉式

    // 延迟加载就是调用get()方法时实例才被创建（先不急着实例化出对象，
    // 等要用的时候才给你创建出来。
    // 常见的实现方法就是在get方法中进行new实例化。


    //只初试化一个
    private static lazy INSTANCE;


    /*创建对象三步：
    1.申请空间
    2.调用init
    3.引用指向内存空间
    2和3可能会指令重排，导致instance拿到的是半初始化状态的对象
     */
    private static volatile lazy INSTANCE2;//禁止指令重排

    private lazy() {//让别人不能new

    }

    //保证别人能获取
    public static lazy getInstance() {//多线程会有问题
        if (INSTANCE == null) {
            INSTANCE = new lazy();
        }
        return INSTANCE;
    }

    public static lazy getInstance2(){//DCL双重检查锁
        if(INSTANCE2 == null){//减少时间开销，不让所有线程都排队等锁释放
            synchronized (lazy.class){//保证创建对象仅此一份
                if(INSTANCE2 == null){//保证只有一个线程能创建对象
                    INSTANCE2 = new lazy();
                    return INSTANCE2;
                }
            }
        }
        return INSTANCE2;
    }
}
