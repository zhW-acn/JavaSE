package fileDemo;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {

    @Test
    public void creatFileTest() throws IOException {
        File file = new File("C:\\Users\\22408\\IdeaProjects\\JavaSE\\IO\\DEMOFILE\\a.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        System.out.println(file.setLastModified(System.currentTimeMillis()));
        System.out.println(file.lastModified());
    }

}
