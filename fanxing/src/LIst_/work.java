package LIst_;//时间：2023/8/1 16:42

import java.util.ArrayList;
import java.util.Collections;

public class work {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        news news1 = new news("新闻一:新冠确诊病例超千万");
        news news2 = new news("新闻二:男子突然想到两个月前的鱼还在网兜里");
//        news1.setContent("新冠确诊病例超千万");
//        news2.setContent("男子突然想到两个月前的鱼还在网兜里");
        list.add(news1);
        list.add(news2);
        Collections.reverse(list);
        System.out.println("倒序后的list" + list);

    }
}

class news{
    private String title;
    private String content;

    public news(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "\nnews{" +
                "title='" + title + '\'' +
                '}';
    }
}