package com.patterns.usage.behavioral.chain;

public abstract class Account {

    protected Account successor;
    protected float balance;

    public void setNext(Account account)
    {
        this.successor = account;
    }

    public float getBalance() {
        return balance;
    }

    public void pay(float amountToPay) throws NotEnoughMonryException
    {
        System.out.format("%s balance: %f\n", this.getClass().getSimpleName(), getBalance());
        if (this.canPay(amountToPay))
        {
            System.out.format("Paid %f using %s\n", amountToPay, this.getClass().getSimpleName());
            return;
        }
        System.out.format("Cannot pay %f using %s. Proceeding ..\n", amountToPay, this.getClass().getSimpleName());

        if(this.successor != null)
            this.successor.pay(amountToPay);
        else
            throw new NotEnoughMonryException("None of the accounts have enough balance");
    }

    public boolean canPay(float amount)
    {
        return this.getBalance() >= amount;
    }
}
