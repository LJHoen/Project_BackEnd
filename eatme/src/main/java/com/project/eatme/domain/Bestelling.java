package com.project.eatme.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bestelling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<Dish> items = new ArrayList<>();
    private double price;

    public Bestelling() {
    }

    public Bestelling(List<Dish> items, double price) {
        this.items = items;
        this.price = price;
    }

    public List<Dish> getItems() {
        return items;
    }

    public void setItems(List<Dish> items) {
        this.items = items;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addDish(Dish dish) {
        this.items.add(dish);
        this.price += dish.getPrice();
    }

    public String toString() {
        return "Bestelling: [" + "id: " + id + "]";
    }
}
