package com.project.eatme.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class KlantAccount extends Account{
    @OneToOne(cascade = CascadeType.ALL)
    private Bestelling currentBestelling;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Bestelling> history;

    public KlantAccount() {}

    public KlantAccount(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
        this.history = new ArrayList<>();
    }


    public KlantAccount(String firstName, String lastName, String username, String password, String address, String bankAccount, Bestelling currentBestelling, List<Bestelling> history) {
        super(firstName, lastName, username, password, address, bankAccount);
        this.history = history;
    }

    public List<Bestelling> getHistory() {
        return history;
    }

    public void setHistory(List<Bestelling> history) {
        this.history = history;
    }

    public Bestelling getCurrentBestelling() {
        return currentBestelling;
    }

    public void setCurrentBestelling(Bestelling currentBestelling) {
        this.currentBestelling = currentBestelling;
    }
}
