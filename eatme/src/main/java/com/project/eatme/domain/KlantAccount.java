package com.project.eatme.domain;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class KlantAccount extends Account{

    @OneToMany
    private List<Bestelling> geschiedenis = new ArrayList<> ();

    public KlantAccount(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }

    public List<Bestelling> getGeschiedenis() {
        return geschiedenis;
    }

    public void setGeschiedenis(List<Bestelling> geschiedenis) {
        this.geschiedenis = geschiedenis;
    }

    public void addBestelling(Bestelling bestelling) {
        this.geschiedenis.add(bestelling);
    }

/**
    public String toString() {
        return "Account: [" + "Name: " + firstName + " " + lastName + ", address: " + address + " bankAccount: " + bankAccount "]";
    }

 **/
}
