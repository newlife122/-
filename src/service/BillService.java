package service;

import dao.BillDao;
import domain.Bill;

import java.util.List;

/**
 * @author raoxin
 */
public class BillService {
    private BillDao mybill = new BillDao();
    public List<Bill> getbillList (int tableid){
        return mybill.queryMulti("select * from bill where tableid = ?", Bill.class,tableid);
    }
    public void BillUpdate(int tableid,int foodid,int ordernum,String uuid){
            mybill.update("insert into bill values(null,?,\"未支付\",?,?,?,now())",uuid,foodid,tableid,ordernum);
    }
    public void BillPayState(int tableid,String uuid,String method){
        mybill.update("update bill set paystate = ? where billuuid = ? and tableid = ?",method,uuid,tableid);
    }

    public List<Bill> ifEixistUnpayed(int tableid){
        return mybill.queryMulti("select * from bill where paystate =\"未支付\" and tableid = ?", Bill.class,tableid);
    }

}
