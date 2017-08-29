package pl.com.bottega.photostock.sales.ui;

import pl.com.bottega.photostock.sales.infrastructure.InMemoryPictureRepository;
import pl.com.bottega.photostock.sales.model.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zbyszek on 2017-08-06.
 */
public class ConsoleApp {
    public static void main(String[] args) {
        //  Set<String> tags = new HashSet<>();
        //  tags.add("kotki");

        //  AbstractProduct picture4 = new AbstractProduct(4L, tags, Money.valueOf(10));

        PictureRepository repository = new InMemoryPictureRepository();
        Picture picture1 = repository.get(1L);
        Picture picture2 = repository.get(2L);
        Picture picture3 = repository.get(3L);
        //repository.save(picture4);

        Client client = new Client("Jan Nowak", new Address("ul. Północna 11", "Poland", "Lublin", "20-234"));
        client.recharge(Money.valueOf(1000000));

        Reservation reservation = new Reservation(client);

        LightBox l = new LightBox(client, "kotki");
        l.add(picture1);
        l.add(picture2);
        l.add(picture3);

        LightBoxPresenter presenter = new LightBoxPresenter();
        presenter.show(l);

        reservation.add(picture1);
        reservation.add(picture2);
        reservation.add(picture3);

        System.out.println(String.format("W rezerwacji jest %d produktów", reservation.getItemsCount()));

        Offer offer = reservation.generateOffer();

        Money cost = offer.getTotalCost();

        if (client.canAfford(cost)) {
            Purchase purchase = new Purchase(client, offer.getItems());
            client.charge(cost, String.format("Zakup %s", purchase));
            System.out.println(String.format("Ilość zakupionych zdjęć: %d, całkowity koszt: %s", offer.getItemsCount(), offer.getTotalCost()));
        } else {
            System.out.println("sorry.... nie stać cię");
        }

        /*System.out.println("total cost: "+cost);
        System.out.println("can efford?: "+client.canAfford(cost));
        System.out.println("balance: "+client.balance());*/

        System.out.println("test \"Money convert(String targetCurrency, Double exRate)\"");
        System.out.println(Money.valueOf(1,"USD").convert("PLN",3.60));

        Map<String, Double> rates = new HashMap<>();
        rates.put("USD", 3.6020);
        rates.put("EUR", 4.2345);
        CurrencyConverter c = new CurrencyConverter("PLN", rates);

        System.out.println(c.convert(Money.valueOf(1,"USD")));
        System.out.println(c.convert(Money.valueOf(1,"EUR")));
    }
}
