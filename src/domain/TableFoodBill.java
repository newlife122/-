package domain;

import java.util.Date;

/**
 * @author raoxin
 */
public class TableFoodBill {
    private Integer billid;

    private String billuuid;
    private String paystate;
    private Integer foodid;
    private Integer tableid;
    private Integer ordernum;
    private Date ordertime;

    private String foodname;

    private Integer price;
    private Integer dinetableid;

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public String getBilluuid() {
        return billuuid;
    }

    public void setBilluuid(String billuuid) {
        this.billuuid = billuuid;
    }

    public String getPaystate() {
        return paystate;
    }

    public void setPaystate(String paystate) {
        this.paystate = paystate;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDinetableid() {
        return dinetableid;
    }

    public void setDinetableid(Integer dinetableid) {
        this.dinetableid = dinetableid;
    }

    @Override
    public String toString() {
        return billid+"\t"+billuuid+'\t'+paystate+"\t"+foodid+"\t"+tableid+"\t"+ordernum+"\t"+ ordertime+"\t"+foodname+"\t价格为："+price;
    }



}
