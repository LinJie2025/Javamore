package jdbc.dao_.pojo;//时间：2024/1/23 16:41

public class Goods {
    private Integer id;
    private String goods_name;
    private double price;
    public Goods(){}

    public Goods(Integer id, String goods_name, double price) {
        this.id = id;
        this.goods_name = goods_name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goods_name='" + goods_name + '\'' +
                ", price=" + price +
                '}';
    }
}
