import java.util.*;

public class Test_ConCurrentModify {

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            nums.add(new Random().nextInt(1000000000));
        }

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Iterator<Integer> iterator = nums.iterator();//会报 ConcurrentModificationException 异常
                while (iterator.hasNext()) {
                    Integer next = iterator.next();//共享变量modCount
                    if (next > 10000)
                        nums.remove(next);
                }
            }).start();
        }
    }

    public static void test2() {
        List<String> nums = new ArrayList<>();
        Collections.addAll(nums, "1", "2", "3");
        for (String nu : nums) {//也会报异常，增强型for循环本质就是个迭代器
            if ("1".equals(nu))
                nums.remove(nu);
        }
    }
    /**以下是ArrayList的remove方法，因为test2()后面只remove了，没有让期望值等于实际值，所以会有下标越界异常
     *  public void remove() {
     *             if (lastRet < 0)
     *                 throw new IllegalStateException();
     *             checkForComodification();
     *
     *             try {
     *                 ArrayList.this.remove(lastRet);
     *                 cursor = lastRet;
     *                 lastRet = -1;
     *                 expectedModCount = modCount;
     *             } catch (IndexOutOfBoundsException ex) {
     *                 throw new ConcurrentModificationException();
     *             }
     *         }
     */
}
