package pl.com.bottega.photostock.sales.model;

/**
 * Created by zbyszek on 2017-08-19.
 */
public abstract class AbstractProduct implements Product {

    private Long number;
    private Money price;
    private Boolean active;
    private Client reservedBy, owner;

    public AbstractProduct(Long number, Money price, Boolean active) {
        this.number = number;
        this.price = price;
        this.active = active;
        Class c = Purchase.class;
    }

    /*  public Money calculatePrice(Client client){
          switch (client.getStatus()){
              case SILVER: return (price.percent(95));
              case GOLD: return price.percent(90);
              case PLATINUM: return price.percent(85);
          }
          return price;
        }*/

    public Money calculatePrice(Client client) {
        return price.percent(100 - client.discountPercent());
    }

    public boolean isAvailable() {
        return active && reservedBy == null;
    }

    public void reservedPer(Client client) {
        if (!isAvailable())
            throw new IllegalStateException("Product is not avilable");
        reservedBy = client;
    }

    public void unreservedPer(Client client) {
        if (owner != null)
            throw new IllegalStateException("Product is already purchased");
        checkReservation(client);
        reservedBy = null;
    }

    public void soldPer(Client client) {
        checkReservation(client);
        owner = client;
    }

    private void checkReservation(Client client) {
        if (!reservedBy.equals(client))
            throw new IllegalStateException(String.format("Product is not reserved by %s", client));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractProduct picture = (AbstractProduct) o;

        return number.equals(picture.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    public Long getNumber() {
        return number;
    }
}
