package service;

import dao.TableFoodBillDao;
import domain.TableFoodBill;

import java.util.List;

/**
 * @author raoxin
 */
public class TableFoodBillService {
    private TableFoodBillDao mytfb = new TableFoodBillDao();
    public List<TableFoodBill> getbillList (int tableid){
        return mytfb.queryMulti("select b.*,f.foodname,b.ordernum*f.foodprice as price from bill b,foodmenu f where b.foodid = f.foodid and tableid =? ", TableFoodBill.class,tableid);
    }
}
