package pl.com.bottega.photostock.sales.ui;

import pl.com.bottega.photostock.sales.model.AbstractProduct;
import pl.com.bottega.photostock.sales.model.Client;
import pl.com.bottega.photostock.sales.model.LightBox;

/**
 * Created by zbyszek on 2017-08-20.
 */
public class LightBoxPresenter {
    public void show(LightBox lightBox){
        System.out.println(lightBox.getName());
        System.out.println("---------------------");
        int i = 1;
        Client client = lightBox.getOwner();
        for(AbstractProduct picture : lightBox.getItems())
           System.out.println(
                   String.format("%s %d. %d | %s",
                     picture.isAvailable() ? "" : "X",
                      i++ ,
                      picture.getNumber(),
                      picture.calculatePrice(client)
                   )
           );
    }
}
