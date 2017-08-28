package pl.com.bottega.photostock.sales.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by zbyszek on 2017-08-19.
 */
public class Purchase {

    private Collection<AbstractProduct> items;
    private Client buyer;
    private LocalDateTime purchaseDate = LocalDateTime.now();

    public Purchase (Client buyer, Collection<AbstractProduct> items){
        this.buyer = buyer;
        this.items = new LinkedList<>(items);

    }
}
