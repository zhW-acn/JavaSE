package DesignMode.匿名内部类示例;

public class AnonymousInner {//匿名内部类

    // 匿名内部类可以使你的代码更加简洁，你可以在定义一个类时同时对其进行实例化。
    // 它与局部类很相似，不同的是它没有类名，
    // 如果某个局部类你只需要用一次，那么你就可以使用匿名内部类。

    /*

    wolf.eat(new Animal() {实现接口的匿名类
            @Override
            public void eat(Animal animal) {
                System.out.println(this.getName() + "吃了" + animal.getName());
            }

            @Override
            public String getName() {
                return "pig";
            }
        });

    tiger.eat(new Wolf(){匿名子类（继承父类）
            @Override
            public void eat(Animal animal) {
                super.eat(animal);
            }

            @Override
            public String getName() {
                return "白狼王";
            }
        });
    操作符：new；
    一个要实现的接口或要继承的类，案例一中的匿名类实现了HelloWorld接口，案例二中的匿名内部类继承了Animal父类；
    一对括号，如果是匿名子类，与实例化普通类的语法类似，如果有构造参数，要带上构造参数；如果是实现一个接口，只需要一对空括号即可；
    一段iu被"{}"括起来类声明主体；
    末尾的";"号（因为匿名类的声明是一个表达式，是语句的一部分，因此要以分号结尾）。

    */


    //注意： 如果匿名内部类要用外部类的本地变量必须是final
    //因为匿名内部类不可能改变外部类方法里的局部变量


}
