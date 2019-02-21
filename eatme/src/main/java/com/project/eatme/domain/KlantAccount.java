package com.project.eatme.domain;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;


@Entity
public class KlantAccount extends Account{

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dish> history = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Dish> currentOrder = new ArrayList<>();

    public KlantAccount(){}

    public KlantAccount(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
        this.history = new ArrayList<> ();
    }

    public KlantAccount(String firstName, String lastName, String username, String password, String address, String bankAccount, List<Dish> history, List<Dish> currentOrder) {
        super(firstName, lastName, username, password, address, bankAccount);
        this.currentOrder = currentOrder;
        this.history = history;
    }

    public List<Dish> getHistory() {
        return history;
    }

    public void setHistory(List<Dish> history) {
        this.history = history;
    }

    public List<Dish> getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(List<Dish> currentOrder) {
        this.currentOrder = currentOrder;
    }

/*
    public String toString() {
        return "Account: [" + "Name: " + this.getFirstName() + " " + this.getLastName() + ", address: " + this.getAddress() + " bankAccount: " + this.getBankAccount() + " current order: " + this.getCurrentOrder() + " history: " + this.getHistory() + "]";
    }
*/
}
