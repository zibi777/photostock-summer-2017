package pl.com.bottega.photostock.sales.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zbyszek on 2017-08-19.
 */
public class LightBox {

    private String name;
    private List<AbstractProduct> items = new LinkedList<>();
    private Client owner;

    public LightBox(Client owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    public void add(AbstractProduct picture) {
        if (items.contains(picture))
            throw new IllegalStateException("Product already added");
        if (!picture.isAvailable())
            throw new IllegalArgumentException("Product is no avilable");
        items.add(picture);
    }

    public void remove(AbstractProduct picture) {
        if (!items.remove(picture))
            throw new IllegalArgumentException("Product not added to lightbox");
    }

    public String getName() {
        return name;
    }

     public Client getOwner() {
        return owner;
    }

    public List<AbstractProduct> getItems() {
        return Collections.unmodifiableList(items);
    }
}
