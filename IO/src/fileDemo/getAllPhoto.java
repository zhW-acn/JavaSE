package fileDemo;

import java.io.File;

public class getAllPhoto {

    public static int count;

    public static void main(String[] args) {
        getAllPhoto(new File("C:\\Users\\22408\\downloads"));
        System.out.println(count);
    }

    public static void getAllPhoto(File file) {
        File[] files = file.listFiles((f, n) -> new File(f, n).isDirectory() || n.contains("jpg"));
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isFile()) {
                getAllPhoto(files[i]);
            } else {
                System.out.println(files[i].getName());
                count++;
            }
        }
    }

}
