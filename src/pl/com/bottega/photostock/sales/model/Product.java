package pl.com.bottega.photostock.sales.model;

/**
 * Created by zbyszek on 2017-08-25.
 */
public interface Product {
    Long getNumber();
    boolean isAvailable();
    Money calculatePrice(Client client);
    void reservedPer(Client client);
    void unreservedPer(Client client);





}
