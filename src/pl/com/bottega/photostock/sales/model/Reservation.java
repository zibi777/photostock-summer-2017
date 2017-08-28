package pl.com.bottega.photostock.sales.model;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by zbyszek on 2017-08-19.
 */
public class Reservation {

    private Client owner;
    private Collection<AbstractProduct> items = new LinkedList<>();

    public Reservation(Client owner){
        this.owner = owner;
    }

    public void add(AbstractProduct picture){
        if (!picture.isAvailable())
            throw new IllegalStateException("Product is not avilable");
        items.add(picture);
        picture.reservedPer(owner);
    }
    public void remove (AbstractProduct picture){
        if (items.remove(picture))
            picture.unreservedPer(owner);
        else
            throw new IllegalArgumentException("Product is not part of this reservation");

    }
    public  Offer generateOffer() {
        return new Offer(owner, items);
    }
    public int getItemsCount() {
        return items.size();
    }
}
