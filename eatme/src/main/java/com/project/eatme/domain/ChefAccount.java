package com.project.eatme.domain;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ChefAccount extends Account {
    @OneToMany
    List<Dish> dishes;
    private int rating;
    private int votes;

    public ChefAccount(){}

    public ChefAccount(String firstName, String lastName, String username, String password){
        super(firstName, lastName, username, password);
        this.dishes = new ArrayList<>();
    }


    public ChefAccount(String firstName, String lastName, String username, String password, String address, String bankAccount, List<Dish> dishes) {
        super(firstName, lastName, username, password, address, bankAccount);
        this.dishes = dishes;
    }

    public ChefAccount(String firstName, String lastName, String username, String password, String address, String bankAccount, List<Dish> dishes, int rating) {
        super(firstName, lastName, username, password, address, bankAccount);
        this.dishes = dishes;
        this.rating = rating;
    }

    public ChefAccount(String firstName, String lastName, String username, String password, String address, String bankAccount, List<Dish> dishes, int rating, int votes) {
        super(firstName, lastName, username, password, address, bankAccount);
        this.dishes = dishes;
        this.rating = rating;
        this.votes = votes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
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
