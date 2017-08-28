package pl.com.bottega.photostock.sales.model;

/**
 * Created by zbyszek on 2017-08-19.
 */
public enum ClientStatus {
    STANDARD(0), VIP(0), GOLD(10), PLATINUM(15), SILVER(5);

    private int discountPercent;

    ClientStatus(int discount){
        this.discountPercent = discount;
    }
    public int getDiscountPercent(){
        return discountPercent;
    }
}
