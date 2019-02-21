package com.project.eatme.domain;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    Double price;

    @OneToMany
    List<Dish> dishes = new ArrayList<>();


    public Menu(){}

    public Menu(int id, String name, Double price, String description, String serveTime) {
        this.id = id;

        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

/**
    @Override
    public String toString() {
        return "[Menu: [" + "id: " + id + ", " + "Name: " + name + "," + "Price: " + price + ","
                + "description: " + description + ", " + "Serve Time: " + serveTime + "]";
    }
     **/
}

