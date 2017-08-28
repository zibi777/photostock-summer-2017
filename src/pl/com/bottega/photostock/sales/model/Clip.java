package pl.com.bottega.photostock.sales.model;

/**
 * Created by zbyszek on 2017-08-26.
 */
public class Clip extends AbstractProduct {

    private Integer length;

    public Clip(Long number, Money price, Boolean active, Integer length) {
        super(number, price, active);
        this.length = length;
    }

    public Integer getLength() {
        return length;
    }
}
