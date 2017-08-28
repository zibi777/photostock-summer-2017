package pl.com.bottega.photostock.model;

import org.junit.Test;
import pl.com.bottega.photostock.sales.model.Address;
import pl.com.bottega.photostock.sales.model.Client;
import pl.com.bottega.photostock.sales.model.ClientStatus;
import pl.com.bottega.photostock.sales.model.Money;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by zbyszek on 2017-08-20.
 */
public class ClientTest {

    private Address address = new Address("ul. Północna 11", "Poland", "Lublin", "20-234");
    private Client client = new Client("Jan Nowak", address,
            ClientStatus.VIP,
            /*Money.valueOf(100),*/
            Money.valueOf(100));
    private final Client clientWithNoMoney = new Client("Jan Nowak", address);

    @Test
    public void shouldCheckIfClientCanAfford(){
        //given
        //when
        clientWithNoMoney.recharge(Money.valueOf(100));
        //then
        assertTrue(clientWithNoMoney.canAfford(Money.valueOf(100)));
        assertTrue(clientWithNoMoney.canAfford(Money.valueOf(50)));
        assertFalse(clientWithNoMoney.canAfford(Money.valueOf(101)));
    }
    @Test
    public void shouldCheckIfClientCanAfford2(){
        //given
        Client client = new Client("Jan Nowak", address,
                ClientStatus.VIP,
                /*Money.valueOf(100),*/
                Money.valueOf(100));
        //then
        assertTrue(client.canAfford(Money.valueOf(100)));
        assertFalse(client.canAfford(Money.valueOf(201)));
    }

    @Test
    public void shouldCheckAndRechargeClient(){
        //given
        //when
        client.charge(Money.valueOf(100),"Testowy zakup");
        client.recharge(Money.valueOf(100));
        //then
        assertTrue(client.canAfford(Money.valueOf(100)));
        assertFalse(client.canAfford(Money.valueOf(101)));
    }

}
