import org.junit.Test;

import java.io.*;

public class Test_io {

    public static String path = "C:\\Users\\22408\\IdeaProjects\\JavaSE\\IO\\DEMOFILE\\a.txt";
    /**
     * 节点流是底层流/低级流,直接跟数据源相接
     * 处理流(包装流)包装节点流，既可以消除不同节点流的实现差异，也可以提供更方便的方法来完成输入输出。
     * 处理流(也叫包装流)对节点流进行包装，使用了修饰器设计模式，不会直接与数据源相连
     */
    @Test
    public void testread1() throws IOException {
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);//文件给节点流，再给包装流
        int read;
//        while (( read = inputStream.read())!=-1){
//            System.out.print((char)read);
//        }
        byte[] bytes = new byte[3];
        StringBuilder sb = new StringBuilder();
        //尝试从输入流中读取最多 bytes.length 个字节的数据，并将实际读取的字节数赋值给 read
        while ((read = inputStream.read(bytes)) != -1) {
            //每次读出多少字节，就把对应的字节转化成字符串
            String s = new String(bytes, 1, read);
            sb.append(s);
        }
        System.out.println(sb);
    }

    @Test
    public void testwrite() throws IOException {
        byte[] bytes = {97,98,99};
        OutputStream outputStream = new FileOutputStream(path,true);
//        for (int i = 0; i < bytes.length; i++) {
//            outputStream.write(bytes[i]);
//        }
//        outputStream.write(bytes);
        outputStream.write("hello".getBytes());
    }
}
