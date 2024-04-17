package LIst_;//时间：2023/7/28 11:05

public class LInkedList_ {
    public static void main(String[] args) {
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node smith = new Node("smith");
        Node jhon = new Node("jhon");
        Node jie = new Node("jie");
        Node first;
        Node last;
        jack.next = tom;
        tom.next = smith;
        smith.next = jhon;
        jhon.next = jie; 
        jie.prve = jhon;
        jhon.prve = smith;
        smith.prve = tom;
        tom.prve = jack;
        first = jack;
        last = jie;
        while(true){
            if(first == null){
                break;
            }
            System.out.println(first);
            first = first.next;
        }
    }
}

class Node{
    String name;
    Node next;
    Node prve;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }
}