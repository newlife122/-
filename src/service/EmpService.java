package service;

import dao.EmpDao;
import domain.EMP;

/**
 * @author raoxin
 */
public class EmpService {
    private EmpDao myempservice = new EmpDao();
    public  EMP getEmp(String username,String psw){
        return myempservice.querySingle("select * from emp where username = ? and password = MD5(?)",EMP.class,username,psw);
    }
}
