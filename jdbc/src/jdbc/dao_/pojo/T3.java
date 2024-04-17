package jdbc.dao_.pojo;//时间：2024/1/23 16:18

public class T3 {
    private Integer id;
    private String name;

    public T3() {
    }

    public T3(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "t3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
