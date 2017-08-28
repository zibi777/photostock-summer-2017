package pl.com.bottega.photostock.sales.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zbyszek on 2017-08-26.
 */
public class Picture extends AbstractProduct {

    private Set<String> tags;

    public Picture(Long number, Money price, Boolean active, Set<String> tags) {
        super(number, price, active);
        this.tags = new HashSet<>(tags);
    }

    public Set<String> getTags() {
        return tags;
    }
}
