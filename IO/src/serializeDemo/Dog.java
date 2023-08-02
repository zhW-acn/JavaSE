package serializeDemo;

import java.io.Serializable;

public class Dog implements Serializable {
    private static final long serialVersionUID = 6814154651910372644L;
    private int age;

    public Dog(){}
    public Dog(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
