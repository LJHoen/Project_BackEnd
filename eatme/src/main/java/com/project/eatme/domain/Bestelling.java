package com.project.eatme.domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bestelling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE} )
    private List<Dish> dishes;

    @ElementCollection
    private List<Integer> dishCount = new ArrayList<>();
    private int price = 0;

    public Bestelling() {
        this.dishes = new ArrayList<>();
    }

    public Bestelling(long id, List<Dish> dishes, List<Integer> dishCount, int price) {
        this.dishes = dishes;
        this.dishCount = dishCount;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Integer> getDishCount() {
        return dishCount;
    }

    public void setDishCount(List<Integer> dishCount) {
        this.dishCount = dishCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
