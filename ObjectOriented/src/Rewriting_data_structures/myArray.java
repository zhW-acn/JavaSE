package Rewriting_data_structures;

public class myArray {
    private int[] elements;//数组
    private int capacity;//数组容量
    private int length;//数组长度

    //构造器,默认数组长度为10
    public myArray(int capacity) {
        elements = new int[capacity];
        this.capacity = capacity;
        length = 0;
    }

    public int getLength(){
        return length;
    }
    //构造函数
    public myArray() {
        this(10);
    }

    //判断数组是否满员
    public boolean isfull() {
        if (length == capacity)
            return true;
        else
            return false;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        if (length == 0)
            return true;
        else
            return false;
    }

    //打印所有数组元素
    public void printArray() {
        String resultPrint = "[";
        for (int i = 0; i < length; i++) {
            resultPrint += elements[i] + ",";
        }
        if (resultPrint.equals("[")) {
            System.out.println("[]");
            return;
        }
        resultPrint = resultPrint.substring(0, resultPrint.length() - 1);
        resultPrint += "]";
        System.out.println(resultPrint);
    }

    public void printAllArray() {
        String resultPrint = "[";
        for (int i = 0; i < capacity; i++) {
            resultPrint += elements[i] + ",";
        }
        if (resultPrint.equals("[")) {
            System.out.println("[]");
            return;
        }
        resultPrint = resultPrint.substring(0, resultPrint.length() - 1);
        resultPrint += "]";
        System.out.println(resultPrint);
    }


    //扩容数组
    public void expansion(int multiple) {//倍数
        int[] temp = new int[this.capacity * multiple];
        for (int i = 0; i < this.capacity; i++) {
            temp[i] = this.elements[i];
        }
        this.elements = temp;
        this.capacity = this.capacity * multiple;
    }

    //增删改查

    //增
    public void add(int index, int data) {//下标索引从1开始
        if (isEmpty() == true && index == 1) {
            elements[index - 1] = data;
            System.out.println("提示：插入" + data + "在" + index + "处成功");
            length++;
        } else if (isfull() == true) {
            System.out.println("提示：数组已满员，请扩容");
            return;
        } else if (index - 1 > length || index > capacity) {//位置合法性
            System.out.println("提示：插入失败，位置不合法");
            return;
        } else if (index - 1 == capacity) {//刚好在最后
            elements[index - 1] = data;
            System.out.println("提示：插入  " + data + "  在  " + index + "  处成功！数组已满员，请及时扩容");
            length++;
            return;
        } else {
            for (int i = length - 1; i > index; i--) {
                elements[i + 1] = elements[i];
            }
            elements[index - 1] = data;
            System.out.println("提示：插入" + data + "在" + index + "处成功");
            length++;
        }
    }

    //重载增方法
    public void add(int data) {//在尾部添加
        if (isEmpty() == true) {
            elements[0] = data;
            System.out.println("提示：插入" + data + "在" + "1处成功");
            length++;
        } else if (isfull() == true) {
            System.out.println("提示：数组已满员，请扩容");
            return;
        } else {
            elements[length - 1] = data;
            length++;
            System.out.println("提示：插入" + data + "在" + (length - 1) + "处成功");
        }

    }

    //删
    public void delete(int index) {
        if (isEmpty() == true) {
            System.out.println("提示：删除失败，数组为空");
            return;
        } else if (index - 1 < 0 || index > length) {//位置合法性
            System.out.println("提示：删除失败，位置不合法");
            return;
        } else if (length == 1) {
            elements[index - 1] = 0;
            System.out.println("提示：成功删除在" + index + "处的元素，此时数组为空。");
            length--;
            return;
        } else {
            for (int i = index; i < length + 1; i++) {
                elements[i - 1] = elements[i];
            }
            System.out.println("提示：成功删除在" + index + "处的元素");
            length--;
            return;
        }

    }

    //改
    public void modify(int index, int data) {
        if (isEmpty() == true) {
            System.out.println("提示：数组为空，修改失败");
            return;
        } else if (index - 1 < 0 || index > length) {//位置合法性
            System.out.println("提示：修改失败，位置不合法");
            return;
        } else {
            elements[index - 1] = data;
            System.out.println("提示：修改在" + index + "处为" + data + "成功");
            return;
        }
    }

    //查
    public Integer query(int index) {
        if (isEmpty() == true) {
            System.out.println("提示：数组为空，查询失败");
            return null;
        } else if (index - 1 < 0 || index > length) {//位置合法性
            System.out.println("提示：查询失败，位置不合法");
            return null;
        } else {
            System.out.println("该位置的元素的值为" + elements[index - 1]);
            return elements[index - 1];
        }
    }

    //冒泡排序从低到高
    public void bubbleSort_LowtoHight() {
        int temp;
        if (length == 0 || length == 1) {
            return;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (elements[j + 1] < elements[j]) {
                    temp = elements[j + 1];
                    elements[j + 1] = elements[j];
                    elements[j] = temp;
                }
            }
        }
        System.out.println("冒泡成功");
    }

    //可变参数，本质是数组。该方法的形参列表只能出现一个可变参数    相当于 sum(int[] nums)
    public int sum(int... nums){
        int result = 0;
        for(int i = 0;i< nums.length;i++){
            result += nums[i];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

