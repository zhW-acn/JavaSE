package homework;

import java.io.*;
import java.util.*;

public class sceneDemo {

    public static Scanner scanner = new Scanner(System.in);

    private static void findOne() {
        System.out.println("请输入商品编号：");
        int id = scanner.nextInt();
        // 函数式编程找到对应id的商品
        Optional<Goods> first = findAllGoods().stream().filter(g -> g.getId() == id).findFirst();
        if (first.isPresent()) {
            Goods goods = first.get();
            System.out.println(goods.getId() + " " + goods.getName() + " " + goods.getPrice());
        } else {
            System.out.println("您需要的商品不存在");
        }
    }

    private static void check() {
        List<Goods> allGoods = findAllGoods();
        for (Goods goods : allGoods) {
            System.out.println(goods.getId() + " " + goods.getName() + " " + goods.getPrice());
        }
    }

    private static void update() {
        // 输入商品id
        System.out.println("请输入商品编号：");
        int id = scanner.nextInt();
        System.out.println("请输入商品名字：");
        String name = scanner.next();
        System.out.println("请输入商品价格：");
        int price = scanner.nextInt();
        // 内存中删除对应的商品
        List<Goods> allGoods = findAllGoods();
        Iterator<Goods> iterator = allGoods.iterator();
        while (iterator.hasNext()) {
            Goods goods = iterator.next();
            if (goods.getId() == id) {
                goods.setName(name);
                goods.setPrice(price);
            }
        }

        // 刷入磁盘
        writeGoods(allGoods, false);
    }

    private static void delete() {
        // 输入商品id
        System.out.println("请输入商品编号：");
        int id = scanner.nextInt();
        // 内存中删除对应的商品
        List<Goods> allGoods = findAllGoods();
        Iterator<Goods> iterator = allGoods.iterator();
        while (iterator.hasNext()) {
            Goods goods = iterator.next();
            if (goods.getId() == id) {
                iterator.remove();
            }
        }

        // 刷入磁盘
        writeGoods(allGoods, false);
    }

    private static void insert() {
        // 防止id重复
        boolean flag = true;
        Integer id = null;
        while (flag) {
            System.out.println("请输入商品编号：");
            id = scanner.nextInt();
            final Integer i = id;
            Optional<Goods> first = findAllGoods().stream().filter(p -> p.getId() == i).findFirst();
            flag = first.isPresent();
            if (flag) {
                System.out.println("该编号已经存在！");
            }
        }

        System.out.println("请输入商品名字：");
        String name = scanner.next();
        System.out.println("请输入商品价格：");
        int price = scanner.nextInt();
        // 最简单，直接追加
        writeGoods(Arrays.asList(new Goods(id, name, price)), true);
    }

    /**
     * 从磁盘中获取所有的数据
     *
     * @return
     */
    private static List<Goods> findAllGoods() {
        List<Goods> goodsList = new ArrayList<>();
        try (Reader reader = new FileReader(Goods.PATH);
             BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
            String goodsStr;
            while ((goodsStr = bufferedReader.readLine()) != null) {
                // 1 肥皂 23
                String[] goodsElem = goodsStr.split(" ");
                Goods goods = new Goods(
                        Integer.parseInt(goodsElem[0]),
                        goodsElem[1],
                        Integer.parseInt(goodsElem[2]));
                goodsList.add(goods);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return goodsList;
    }

    private static void writeGoods(List<Goods> allGoods, boolean append) {
        try (Writer writer = new FileWriter(Goods.PATH, append);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
        ) {
            for (Goods goods : allGoods) {
                bufferedWriter.write(goods.getId() + " " + goods.getName() + " " + goods.getPrice());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        while (true) {
            System.out.println("请选择功能：1、插入新商品 2、删除商品 3、修改商品 4、查看商品 4、查看一个商品 5、退出");
            int function = scanner.nextInt();
            switch (function) {
                case 1:
                    insert();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    check();
                    break;
                case 5:
                    findOne();
                    break;
                case 6:
                    System.exit(-1);
                    break;
            }
        }
    }


}
