package pl.com.bottega.photostock.sales.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zbyszek on 2017-08-28.
 */
public class CurrencyConverter {

    private String mainCurrency;
    private Map<String, Double> exchangeRates = new HashMap<>();

    public CurrencyConverter(String mainCurrency, Map<String, Double> exchangeRates) {
        this.mainCurrency = mainCurrency;
        this.exchangeRates = exchangeRates;
    }

   /* private boolean hasDefinedExRate (Money amount){
        return this.exchangeRates.containsKey(amount.currency());
    }*/

    public Money convert(Money amount) {
        if (mainCurrency.equals(amount.currency()))
            return amount;
        else if (this.exchangeRates.containsKey(amount.currency()))
            return amount.convert(mainCurrency, exchangeRates.get(amount.currency()));
        else throw new IllegalStateException("No exRate for main currency");
    }

    public Money convert(Money amount, String currency) {
        if (!exchangeRates.containsKey((currency)))
            throw new IllegalStateException("No exRate");
        else if (mainCurrency.equals(currency))
            return convert(amount);
        else if (mainCurrency.equals(amount.currency()))
            return amount.convert(currency, 1 / exchangeRates.get(currency));
        else {
            amount = convert(amount);
            return amount.convert(currency, 1 / exchangeRates.get(currency));
        }
    }
}
