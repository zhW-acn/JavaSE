package reflex;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflexTest {
    @Test// 创建反射
    public void creatReflex(){
        // 使用类名
        Class<User> clazz1 = User.class;
        // 使用用对象
        User user = new User();
        Class<? extends User> clazz2 = user.getClass();
        // forname,全限定名
        Class<?> clazz3 = null;
        try {
            clazz3 = Class.forName("reflex.User");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
    }

    @Test// 反射操作成员变量
    public void FieldTest() throws NoSuchFieldException, IllegalAccessException {
        Class<User> clazz1 = User.class;
        // 可以new
        try {
            User user1 = clazz1.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        /**
         * 三个
         * getFields
         * getDeclaredFields
         * getDeclaredField()
         */
        // 成员变量,这个方法只能拿到public的成员变量
        Field[] fields = clazz1.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        // 这个方法可以获取所有的成员变量
        fields = clazz1.getDeclaredFields();
        // 通过反射给成员变量赋值
        User user1 = new User();
        Field name = null;
        // 直接设置值，不能是private
        name = clazz1.getDeclaredField("name");

        /**
         * 两个
         * get，set
         */
//        name.set(user1, "name");
        // 设置访问权限，暴力注入，私有变量也可以赋值
        name.setAccessible(true);
        name.set(user1, "name");
        System.out.println(name.get(user1));// 默认调用toString方法
    }
    @Test// 反射操作方法
    public void methodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<User> clazz = User.class;
        // getMethods拿到的是父类和public方法
        Method[] methods = clazz.getDeclaredMethods();// 拿到本类定义的所有方法
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        Method privatemethod = clazz.getDeclaredMethod("privateMethod");
        Method privatemethod2 = clazz.getDeclaredMethod("privateMethod",String.class);

        // 设置可见
        privatemethod.setAccessible(true);
        privatemethod.invoke(new User());// 要是public或设为可见
        privatemethod2.invoke(new User(),"a");
    }

    @Test// 反射操作构造器
    public void constructorTest() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<User> clazz = User.class;
        Constructor<User> declaredConstructor = clazz.getDeclaredConstructor();
        // 获取无参构造，构造对象
        Constructor<User> declaredConstructor1 = clazz.getDeclaredConstructor();
        User user = declaredConstructor1.newInstance();// new User
        // 有参
        Constructor<User> declaredConstructor2 = clazz.getDeclaredConstructor(String.class,int.class);
        User user2 = declaredConstructor2.newInstance("user",18);

    }
}
