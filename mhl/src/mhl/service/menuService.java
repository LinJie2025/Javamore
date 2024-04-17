package mhl.service;//时间：2024/1/24 16:27

import mhl.pojo.Menu;
import mhl.dao.menuDAO;
import java.util.List;

public class menuService {
    private menuDAO menuDAO = new menuDAO();
    public List<Menu> showAll(){
        List<Menu> menus = menuDAO.queryMulti("select * from menu", Menu.class);
        return menus;
    }

    public Menu getMenuById(int id){
        Menu menu = menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
        return menu;
    }
}
