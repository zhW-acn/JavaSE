import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test_Collections {
    public static void main(String[] args) {

        List<Integer> numbs = new ArrayList<>();
        Collections.addAll(numbs,1,2,3,4,5);
        Collections.shuffle(numbs,new Random(2));
        System.out.println(numbs);

    }
}
