package serializeDemo;

import org.junit.Test;

import java.io.*;

public class CopyObject {
    @Test
    public void writeObjectTest() throws IOException {
        OutputStream outputStream = new FileOutputStream("C:\\Users\\22408\\IdeaProjects\\JavaSE\\IO\\DEMOFILE\\a.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        // 写一个对象到磁盘 序列化
        objectOutputStream.writeObject(new User(18,"zhangsan"));
        objectOutputStream.close();// 如果对象没有序列化接口会有NotSerializableException
    }

    @Test
    public void readObjectTest() throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream("C:\\Users\\22408\\IdeaProjects\\JavaSE\\IO\\DEMOFILE\\a.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        // 拿到对象 反序列化
        User user = (User)objectInputStream.readObject();
        System.out.println(user.getAge());
        System.out.println(user.name);
    }

    @Test
    public void noDeepCopyTest() throws CloneNotSupportedException {
        User user = new User(12,"zhangsan");
        user.setDog(new Dog(2));
        User user1 = (User) user.clone();// 浅拷贝

        user.getDog().setAge(1);
        System.out.println(user1);
    }

    @Test
    public void DeepCopyTest() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        User user = new User(12,"zhangsan");
        user.setDog(new Dog(2));
        // 写个工具类
        User user1 = DeepCopyUtil.deepCopy(user);

        user.setAge(13);
        user.getDog().setAge(1);
        System.out.println(user);
        System.out.println(user1);
    }
}
