package Arrays_;//时间：2023/7/27 15:20

import java.util.Arrays;
import java.util.Comparator;

public class Arrays_Excercise01 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅", 90);
        books[2] = new Book("青年文摘", 5);
        books[3] = new Book("Java从入门到放弃", 300);
        System.out.println("按照价格排序");
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getPrice() - b2.getPrice();
            }
        });
        System.out.println(Arrays.toString(books));
        System.out.println("按照书名长度排序");
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getName().length() - b2.getName().length();
            }
        });
        System.out.println(Arrays.toString(books));
    }
}
class Book{
    String name;
    int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}