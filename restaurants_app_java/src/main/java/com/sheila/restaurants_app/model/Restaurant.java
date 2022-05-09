package com.sheila.restaurants_app.model;

public class Restaurant {

    private int restaurantId;
    private String name;

    //constructor
    public Restaurant() {
    }

    //getters and setters to access private variables

    public int getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
