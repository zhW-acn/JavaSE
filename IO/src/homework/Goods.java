package homework;

public class Goods {
    public static final String PATH = "F:\\IdeaProjects\\Filed\\JavaSE\\IO\\DEMOFILE\\shop.txt";
    private static Integer Id;// 商品ID

    private static String Name;// 商品名

    private static Integer Price;// 商品价格


    public Goods() {
    }

    public Goods(Integer ID, String NAME, Integer PRICE) {
        this.Id = ID;
        this.Name = NAME;
        this.Price = PRICE;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer ID) {
        Goods.Id = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String NAME) {
        Goods.Name = NAME;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer PRICE) {
        Goods.Price = PRICE;
    }
}
