package domain;

import java.util.Date;

/**
 * @author raoxin
 */
public class Bill {
    private Integer billid;

    private String billuuid;
    private String paystate;
    private Integer foodid;
    private Integer tableid;
    private Integer ordernum;
    private Date ordertime;

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
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
        foodid = foodid;
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
    public String getBilluuid() {
        return billuuid;
    }

    public void setBilluuid(String billuuid) {
        this.billuuid = billuuid;
    }

    @Override
    public String toString() {
        return billid+"\t"+billuuid+'\t'+paystate+"\t"+foodid+"\t"+tableid+"\t"+ordernum+"\t"+ ordertime+"\t";
    }
}
