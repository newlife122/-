package domain;

/**
 * @author raoxin
 */
public class FoodMenu {
    private Integer foodid;
    private String foodname;
    private String foodclass;
    private Integer foodprice;
    private Integer foodStorenum;

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodclass() {
        return foodclass;
    }

    public void setFoodclass(String foodclass) {
        this.foodclass = foodclass;
    }

    public Integer getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(Integer foodprice) {
        this.foodprice = foodprice;
    }

    public Integer getFoodStorenum() {
        return foodStorenum;
    }

    public void setFoodStorenum(Integer foodStorenum) {
        this.foodStorenum = foodStorenum;
    }

    @Override
    public String toString() {
        return '\t'+""+foodid+'\t'+foodname+'\t'+foodclass+'\t'+foodprice+'\t'+foodStorenum;
    }
}
