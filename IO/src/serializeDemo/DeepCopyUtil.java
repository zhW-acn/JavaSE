package serializeDemo;

import java.io.*;

public class DeepCopyUtil {
    /**
     * t -> byteArrayOutputStream -> objectOutputStream -> bytes -> byteArrayInputStream -> objectInputStream --read--> return Object
     */
    public static <T> T deepCopy(T t) throws IOException, ClassNotFoundException {

        // 将对象写到字节数组中
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(t);
        // 获取字节数组
        byte[] bytes = byteArrayOutputStream.toByteArray();
        // 用输入流读出来
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object o = objectInputStream.readObject();
        // 关闭流
        objectInputStream.close();
        byteArrayInputStream.close();
        objectOutputStream.close();
        byteArrayOutputStream.close();

        return (T) o;
    }
}
