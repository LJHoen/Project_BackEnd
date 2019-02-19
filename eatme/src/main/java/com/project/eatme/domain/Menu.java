package com.project.eatme.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;
    Double price;
    String description;
    String serveTime;

    public Menu(){}

    public Menu(int id, String name, Double price, String description, String serveTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.serveTime = serveTime;}
    public int getId() { return id; }
    public void setId(int id)  { this.id = id; }
    public String getName() { return name; }
    public void setName(String name)  { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price)  { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description)  { this.description = description; }
    public String getServeTime() { return serveTime; }
    public void setServeTime(String serveTime)  { this.serveTime = serveTime; }
    @Override
    public String toString() {
        return "[Menu: [" + "id: " + id + ", " + "Name: " + name + "," + "Price: " + price + ","
                + "description: " + description + ", " + "Serve Time: " + serveTime + "]";
    }
}

