package preStudy;

import java.util.Optional;
import java.util.Scanner;

/**
 * Optional类是Java8为了解决null值判断问题，借鉴google guava类库的Optional类而引入的一个同名Optional类，
 * 使用Optional类可以避免显式的null值判断（null的防御性检查），避免null导致的NPE（NullPointerException）。
 */
public class Test_Optional {

    public static void main(String[] args) {

        /**创建
         * Optional<String> optStr = Optional.empty();// 空对象
         * Optional<String> optStr1 = Optional.of("optional");// 非空对象
         * Optional<String> optStr2 = Optional.ofNullable(null);// 可空对象
         */

        User user = new User("存在对象");
        if (new Scanner(System.in).nextInt() == 0) {
            user = null;
        }
        Optional<User> optionalUser = Optional.ofNullable(user);

        user = optionalUser.orElse(new User("对象为null"));
        System.out.println(user);

        optionalUser.ifPresent(System.out::println);//如果存在，就打印名字(u -> System.out.println(u))

        user = optionalUser.orElseGet(() -> new User("给你new一个对象"));
        System.out.println(user);

        user = optionalUser.orElseThrow(() -> new RuntimeException("如果是null，抛出异常"));
        System.out.println(user);

    }

}
