package view;

import utils.JDBCUtilsByDruid;
import utils.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author raoxin
 */
public class View {
    public static void main(String[] args) throws Exception{
        Connection a = JDBCUtilsByDruid.getConnection();
        String sql = "select * from tb_emp";
        PreparedStatement mystate = a.prepareStatement(sql);
        ResultSet myset= mystate.executeQuery();
        while (myset.next()){
            System.out.print(myset.getInt(1));
            System.out.print(myset.getString(2));
            System.out.print(myset.getString(3));
            System.out.print(myset.getString(4));
            System.out.println();
        }
        new View();
    }
    boolean flag = true;
    char key;
    public View(){
        while (flag){
            System.out.println("===============满汉楼===============");
            System.out.println("\t\t\t1 登录满汉楼");
            System.out.println("\t\t\t2 登录满汉楼");
            System.out.print("请输入你的选择：");
            key = Utility.readChar();
            switch (key){
                case '1':
                    System.out.println("请输入员工号：");
                    System.out.println("请输入密  码：");
                    break;
                case '2':
                    flag = false;
                    System.out.println("你已退出该系统！");
                    break;
            }
        }
    }
}
