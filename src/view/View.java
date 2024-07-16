package view;

import domain.Bill;
import domain.DineTable;
import domain.FoodMenu;
import service.BillService;
import service.DineTableSercice;
import service.EmpService;
import service.FoodMenuService;
import utils.JDBCUtilsByDruid;
import utils.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

/**
 * @author raoxin
 */
public class View {
    public static void main(String[] args) throws Exception{
        new View();
    }
    boolean flag = true;
    char key;
    EmpService empservice = new EmpService();
    DineTableSercice tableSercice = new DineTableSercice();
    FoodMenuService menuService = new FoodMenuService();
    BillService billService = new BillService();
    public void showTables(){
        List<DineTable> tablelist = tableSercice.getTableList();
        for (DineTable dineTable : tablelist) {
            System.out.println("餐桌"+dineTable.getDinetableid()+"状态为："+dineTable.getTablestate());
        }
    }
    public void showfoodMenu(){
        List<FoodMenu> menuList = menuService.getMenuList();
        System.out.println("foodid\tfoodname\tfoodclass\tfoodprice\tfoodstorenum");
        for (FoodMenu foodMenu : menuList) {
            System.out.println(foodMenu);
        }
    }
    public void orderTable(int tableid){
        String state = tableSercice.getTableState(tableid);
        if ("空".equals(state)){
            System.out.println("预定成功");
            tableSercice.tableUpdateTo("已预定",tableid);
            return;
        }
        System.out.println("预定失败，检查预定桌状态");
    }

    public void orderFood(int foodid,int num,int tableid){
        UUID uuid = UUID.randomUUID();
        String uuidstr = uuid.toString().replace("-","");

        String state = tableSercice.getTableState(tableid);
        if (state == null){
            System.out.println("该桌子不存在");
            return;
        }
        tableSercice.tableUpdateTo("正在用餐",tableid);

        FoodMenu mymenu = menuService.getfood(foodid);
        if (mymenu ==null){
            System.out.println("你好，该菜品不存在");
            return;
        }
        if (mymenu.getFoodStorenum()<num){
            System.out.println("你好，该菜品数量不够");
            return;
        }
        menuService.foodMenuUpdate(foodid,num);
        billService.BillUpdate(tableid,foodid,num,uuidstr);
    }

    public void showbills(int tableid){
        List<Bill> billList = billService.getbillList(tableid);
        if (billList.size()==0){
            System.out.println("这张桌子没有账单");
            return;
        }
        for (Bill bill : billList) {
            System.out.println(bill);
        }
    }
    public void paybill(){
        System.out.print("你想结账的桌子为：");
        int tableid = Utility.readInt();
        String state = tableSercice.getTableState(tableid);
        if (state == null){
            System.out.println("该桌子不存在");
            return;
        }

        List<Bill> billList = billService.ifEixistUnpayed(tableid);
        if (billList.size()==0){
            System.out.println("你已经付完了");
            return;
        }
        for (Bill bill : billList) {

            String method;
            do{
                    System.out.print("请选择方法支付：");
                    method = Utility.readString(10);
            } while (!"支付宝".equals(method)&&!"微信".equals(method));
            billService.BillPayState(tableid,bill.getBilluuid(),method);
            tableSercice.tableUpdateTo("空",tableid);
            System.out.println(bill);
        }

    }

    public View(){
        while (flag){
            System.out.println("===============满汉楼===============");
            System.out.println("\t\t\t1 登录满汉楼");
            System.out.println("\t\t\t2 退出");
            System.out.print("请输入你的选择：");
            key = Utility.readChar();
            switch (key){
                case '1':
                    System.out.print("请输入员工号：");
                    String user = Utility.readString(10);
                    System.out.print("请输入密  码：");
                    String psw = Utility.readString(15);
                    if (empservice.getEmp(user,psw) != null){
                        while (flag){
                            System.out.println("===============满汉楼二级菜单===============");
                            System.out.println("\t\t\t1 显示餐桌状态");
                            System.out.println("\t\t\t2 预定餐桌");
                            System.out.println("\t\t\t3 显示所有菜品");
                            System.out.println("\t\t\t4 点餐服务");
                            System.out.println("\t\t\t5 查看账单");
                            System.out.println("\t\t\t6 结账");
                            System.out.println("\t\t\t9 退出满汉楼");
                            System.out.print("请输入你的选择：");
                            key = Utility.readChar();
                            switch (key){
                                case '1':
                                    showTables();
                                    break;
                                case '2':
                                    System.out.print("请输入你想预定的餐桌：");
                                    int tableid = Integer.parseInt(new String(Utility.readString(10)));
                                    orderTable(tableid);
                                    break;
                                case '3':
                                    showfoodMenu();
                                    break;
                                case '4':
                                    System.out.println("你想定的餐桌为：");
                                    int table = Utility.readInt();
                                    System.out.print("你想点的是：");
                                    int foodid = Utility.readInt();
                                    System.out.print("你想点的数量为：");
                                    int num = Utility.readInt();
                                    orderFood(foodid,num,table);
                                    break;
                                case '5':
                                    System.out.print("你想定的餐桌为：");
                                    int table1 = Utility.readInt();
                                    showbills(table1);
                                    break;
                                case '6':
                                    paybill();
                                    break;
                                case '9':
                                    flag = false;
                                    System.out.println("你已退出该系统！");
                                    break;
                                default:
                                    System.out.println("输错了");
                            }
                        }
                    }
                    break;
                case '2':
                    flag = false;
                    System.out.println("你已退出该系统！");
                    break;
            }
        }
    }
}
