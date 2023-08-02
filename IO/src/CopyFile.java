import java.io.*;

public class CopyFile {
    public static String sourcePath = "Y:\\ACG\\动漫\\看过\\进击的巨人\\OAD\\[ReinForce] Shingeki no Kyojin - OAD 0,5 A (BDRip 1920x1080 x264 FLAC).mkv";
    public static String targetPath = "C:\\Users\\22408\\IdeaProjects\\JavaSE\\IO\\DEMOFILE\\targetDirectory\\2.mkv";
    public static void main(String[] args) throws IOException {

        /**
         * //把输入流建立在文件上
         * InputStream inputStream = new FileInputStream(sourcePath);
         * // 建立一个输出流
         * OutputStream outputStream = new FileOutputStream(targetPath);
         * // 一边读流中的字节，一边写出到文件
         * Long start = System.currentTimeMillis();
         * //        int b;// 一个字节为单位读
         * //        while ((b = inputStream.read())!=-1){
         * //            outputStream.write(b);
         * //        }
         * byte[] buf = new byte[1024 * 1024];// 扩大缓冲区:Byte KB MB GB
         * int len;
         * while ((len = inputStream.read(buf)) != -1) {
         *      outputStream.write(buf, 0, len);
         * }
         * Long end = System.currentTimeMillis();
         * System.out.println(end - start);
         */

        // 正确写法
        try (InputStream inputStream =new FileInputStream(sourcePath);
             OutputStream outputStream = new FileOutputStream(targetPath))//定义字节流
        {
            byte[] buf = new byte[1024 * 1024];
            int len;
            Long start = System.currentTimeMillis();
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            Long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch(IOException e){
            e.printStackTrace();
        }//finally不用写
    }
}
