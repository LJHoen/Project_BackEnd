package com.project.eatme.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bestelling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dish> dishes = new ArrayList<>();

    private double price;

    public Bestelling() {
    }

    public Bestelling(List<Dish> dishes, double price) {
        this.dishes = dishes;
        this.price = price;

    }

    public List<Dish> getItems() {
        return dishes;
    }

    public void setItems(List<Dish> items) {
        this.dishes = items;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
        this.price += dish.getPrice();
    }

    public String toString() {
        return "Bestelling: [" + "id: " + id + "]";
    }
}
