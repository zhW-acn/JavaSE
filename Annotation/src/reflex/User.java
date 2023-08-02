package reflex;
@MyAnnotation(age = 0)
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }


    private void privateMethod(){
        System.out.println("I am a private method");
    }

    public void privateMethod(String s){
        System.out.println("I am a Override private method " + s);
    }


    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.getName()+user.getAge());
    }
}
