package serializeDemo;

import java.io.Serializable;

public class User implements Serializable,Cloneable {
    int age;
    transient String  name; // transient表示不可序列化
    private static final long serialVersionUID = 1L;// 序列化版本,只要自己制定了，JVM就不会再给一个序列版本号

    private Dog dog;

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public User(int age, String a) {
        this.age = age;
        this.name = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String a) {
        this.name = a;
    }



    public User(){

    }
    public User(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
