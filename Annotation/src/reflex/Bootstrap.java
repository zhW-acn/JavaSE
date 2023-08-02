package reflex;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bootstrap {

    public static final List<String> PATHS = new ArrayList<>();// 保存所有文件的绝对路径

    public static void main(String[] args) {
        final URL resource = Thread.currentThread().getContextClassLoader().getResource("");
        getAllClass(new File(resource.getFile()));
       // System.out.println(PATHS);// C:\Users\22408\IdeaProjects\JavaSE\out\production\Annotation\AnnotationTest.class
        // 变成全限定名称然后Class.forName()
        // 遍历绝对路劲变成全限定名
        List<String> collect = PATHS.stream().map(path -> {
            String file = new File(resource.getFile()).getAbsolutePath();
            file = path.replace(file + "\\", "").replaceAll("\\\\",".").replace(".class","");
            return file;
        }).collect(Collectors.toList());

        System.out.println(collect);
    }

    public static void getAllClass(File file) {
        File[] files = file.listFiles((f, n) -> new File(f, n).isDirectory() || n.contains(".class"));
        for (File parent : files)
            if (!parent.isFile())
                getAllClass(parent);
            else
                PATHS.add(parent.getAbsolutePath());
    }
}
