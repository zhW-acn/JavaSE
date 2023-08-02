import java.io.*;

/** 字节流和字符流的区别：
 * 字节流 ：字节读写，  字节流(ASCII)处理二进制文件。
 * 可以传输音频，视频，图片，文本等，传输数据的基本单位为字节。InputStream OutputStream
 *
 * 字符流：快读写 ，字符流(Unicode)处理文本文件。
 * 只能传输纯文本， 传输数据的基本单位为字符 。FileWriter FileReader
 *
 * 一个字符等于2个字节
 */

public class Reader_Writer {
    public static String sourcePath = "C:\\Users\\22408\\IdeaProjects\\JavaSE\\IO\\DEMOFILE\\a.txt";
    public static String targetPath = "C:\\Users\\22408\\IdeaProjects\\JavaSE\\IO\\DEMOFILE\\targetDirectory\\b.txt";
    public static void main(String[] args) throws IOException {
        //把输入流建立在文件上
         Reader reader = new FileReader(sourcePath);
         // 建立一个输出流
         Writer writer = new FileWriter(targetPath);
         // 一边读流中的字节，一边写出到文件
         Long start = System.currentTimeMillis();
         int c;
         while ((c = reader.read()) != -1) {
              writer.write(c);
         }
         Long end = System.currentTimeMillis();
         System.out.println(end - start);

         writer.flush();// 刷到磁盘上去
         reader.close();// 调用close会顺带调用flush
         writer.close();
    }
}
