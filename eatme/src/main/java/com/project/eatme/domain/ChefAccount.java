package com.project.eatme.domain;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ChefAccount extends Account {
    @OneToMany
    private List<Dish> menu = new ArrayList<>();
    private int rating;
    private int votes;

    public ChefAccount(){}

    public ChefAccount(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    public void addDish(Dish dish) {
        this.menu.add(dish);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
       this.rating = rating;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void rate(int rating) {
        if(votes == 0) {
            this.rating = rating;
        } else {
            this.rating = (rating * votes + rating) / (votes + 1);
        }

        if(this.rating > 10) {
            this.rating = 10;
        } else if(this.rating < 1) {
            this.rating = 1;
        }
        this.votes++;
    }

    /**
    public String toString() {
        return "Account: [" + "Name: " + firstName + " " + lastName + ", address: " + address + " bankAccount: " + bankAccount "]";
    }

     **/
}
