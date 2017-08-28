package pl.com.bottega.photostock.sales.model;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zbyszek on 2017-08-06.
 */
public class Offer {

    private Client owner;
    private List<AbstractProduct> items;

    public Offer (Client owner, Collection<AbstractProduct> items){
        this.owner = owner;
        this.items = new LinkedList<>(items);
        this.items.sort(new Comparator<AbstractProduct>() {
            @Override
            public int compare(AbstractProduct o1, AbstractProduct o2) {
                return o2.calculatePrice(owner).compareTo(o1.calculatePrice(owner));
            }
        });
    }

    public boolean sameAs(Offer offer, Money tolerance){
        return false;
    }
    public int getItemsCount(){
        return items.size();
    }
    public Money getTotalCost(){
        Money totalCost = Money.ZERO;
        for (AbstractProduct picture : items){
           totalCost =  totalCost.add(picture.calculatePrice(owner));
        }
        return totalCost;
    }

    public Collection<AbstractProduct> getItems() {
        return new LinkedList<>(items);
        //druga metoda:
        //Collections.unmodifiableCollection(items);
    }
}
