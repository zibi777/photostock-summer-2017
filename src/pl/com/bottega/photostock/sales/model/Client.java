package pl.com.bottega.photostock.sales.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zbyszek on 2017-08-19.
 */
public class Client {

    private String name;
    private Address address;
    private ClientStatus status;
    /*private Money balance;*/
    private Money creditLimit;
    private List<Transaction> transactions = new LinkedList<>();

    private Money balance(){
        Money balance = Money.ZERO;
        /*Money balance2 = Money.ZERO;*/
        for (Transaction transaction : transactions){
            /*balance2 = transaction.getAmount();
            balance = balance.add(balance2);
            balance.add(transaction.getAmount());*/
            balance = balance.add(transaction.getAmount());
            //return transaction.getAmount();
        }
        return balance;
        //return Money.ZERO.add(balance);
    }

    public ClientStatus getStatus() {
        return status;
    }

    public Client(String name, Address address, ClientStatus status, /*Money balance,*/ Money creditLimit) {
        this.name = name;
        this.address = address;
        this.status = status;
        /*this.balance = balance;*/
        this.creditLimit = creditLimit;
        /*if (balance.gt(Money.ZERO))
            transactions.add(new Transaction(balance, "First charge"));*/
    }

    public Client(String name, Address address){
        this(name, address, ClientStatus.STANDARD, /*Money.ZERO,*/ Money.ZERO);
    }

    public boolean canAfford (Money amount){
        Money budget = balance();
        budget = budget.add(creditLimit);
        /*return  amount.lte(balance.add(creditLimit)) ;*/
        return amount.lte(budget);
    }

    public void charge (Money amount, String reason ){
        if(!canAfford(amount))
            throw new IllegalStateException("Not enough balance");
        /*balance = balance.subtract(amount);*/
        transactions.add(new Transaction(amount.neg(), reason));
    }

    public void recharge(Money amount){
        /*balance = balance.add(amount);*/
        transactions.add(new Transaction(amount,"Recharge account"));
    }

    public int discountPercent() {
        return status.getDiscountPercent();
    }
}
