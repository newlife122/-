package service;

import dao.DineTableDao;
import domain.DineTable;

import java.util.List;

/**
 * @author raoxin
 */
public class DineTableSercice {
    private DineTableDao mydinetable = new DineTableDao();
    public List<DineTable> getTableList(){
        return mydinetable.queryMulti("select * from dinetable",DineTable.class);
    }
    public String getTableState(int tableid){
        return (String) mydinetable.queryScalar("select tablestate from dinetable where dinetableid = ?",tableid);
    }

    public void tableUpdateTo(String str,int tableid){
        mydinetable.update("update dinetable set tablestate = ? where dinetableid = ?",str,tableid);
    }
}
