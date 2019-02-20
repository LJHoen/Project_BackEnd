package com.project.eatme.domain;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;


@Entity
public class KlantAccount extends Account{

    @OneToMany
    private List<Bestelling> history = new ArrayList<> ();
    @OneToOne
    private Bestelling currentOrder = new Bestelling();

    public KlantAccount(){}

    public KlantAccount(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }

    public KlantAccount(String firstName, String lastName, String username, String password, String address, String bankAccount, List<Bestelling> history, Bestelling currentOrder) {
        super(firstName, lastName, username, password, address, bankAccount);
        this.currentOrder = currentOrder;
        this.history = history;
    }

    public Bestelling getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Bestelling currentOrder) {
        this.currentOrder = currentOrder;
    }

    public List<Bestelling> getHistory() {
        return history;
    }

    public void setGeschiedenis(List<Bestelling> geschiedenis) {
        this.history = geschiedenis;
    }

    public void addBestelling(Bestelling bestelling) {
        this.history.add(bestelling);
    }

/*
    public String toString() {
        return "Account: [" + "Name: " + this.getFirstName() + " " + this.getLastName() + ", address: " + this.getAddress() + " bankAccount: " + this.getBankAccount() + " current order: " + this.getCurrentOrder() + " history: " + this.getHistory() + "]";
    }
*/
}
