package pl.com.bottega.photostock.sales.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zbyszek on 2017-08-28.
 */
public class CurrencyConverter {

    private String mainCurrency;
    private Map<String, Double> exchangeRates = new HashMap<>();

    public CurrencyConverter (String mainCurrency, Map<String, Double> exchangeRates){
        this.mainCurrency = mainCurrency;
        this.exchangeRates = exchangeRates;
    }

    private boolean hasDefinedExRate (Money amount){
        return this.exchangeRates.containsKey(amount.currency());
    }

    public Money convert (Money amount){
        if (mainCurrency.equals(amount.currency()))
            return amount;
        else if (hasDefinedExRate(amount))
            return amount.convert(mainCurrency,exchangeRates.get(amount.currency()));
            else throw new IllegalStateException("No exRate for main currency");
    }
}
