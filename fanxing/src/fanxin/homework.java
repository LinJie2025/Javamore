package fanxin;//时间：2023/8/2 15:31

import org.junit.jupiter.api.Test;

import java.util.*;

public class homework {
    public static void main(String[] args) {

    }

    @Test
    public void test(){
        DAO<User> dao = new DAO<>();
        dao.save("1", new User("jack",18,1));
        dao.save("2", new User("tom",28,2));
        dao.save("3", new User("mike",22,3));
        System.out.println(dao.get("1"));
        System.out.println(dao.get("2"));
        System.out.println(dao.get("3"));
        System.out.println(dao.list());
        dao.update("1",new User("marry",25,1));
        System.out.println(dao.get("1"));
    }
}

class DAO<T> {
    private Map<String,T> map = new HashMap<>();
    public T get(String id){
        return map.get(id);
    }
    public void update(String id, T entity){
        map.put(id,entity);
    }
    public List<T> list(){
        Set<Map.Entry<String, T>> entries = map.entrySet();
        Iterator<Map.Entry<String, T>> iterator = entries.iterator();
        List<T> arr = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<String, T> next =  iterator.next();
            arr.add(next.getValue());
        }
        return arr;
    }
    public void delete(String id){
        map.remove(id);
    }
    public void save(String id,T entity){
        map.put(id,entity);
    }
}

class User{
    private String name;
    private int age;
    private int id;

    public User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}