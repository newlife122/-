package service;

import dao.FoodMenuDao;
import domain.FoodMenu;
import java.util.List;

/**
 * @author raoxin
 */
public class FoodMenuService {
    private FoodMenuDao myfoodmenu = new FoodMenuDao();
    public List<FoodMenu> getMenuList(){
        return myfoodmenu.queryMulti("select * from foodmenu",FoodMenu.class);
    }
    public void foodMenuUpdate(int foodid,int num){
        myfoodmenu.update("update foodmenu set foodstorenum = (foodstorenum - ?) where foodid = ?",num,foodid);
    }

    public FoodMenu getfood(int foodid){
        return myfoodmenu.querySingle("select * from foodmenu where foodid = ?",FoodMenu.class,foodid);
    }
}
