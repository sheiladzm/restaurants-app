package com.sheila.restaurants_app.model;

public class Address {

    private int addressId;
    private String name;
    private String foodTypes;
    private String schedule;
    private int restaurantId;

    //constructor
    public Address() {
    }

    //getters and setters to access private variables

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFoodTypes() {
        return foodTypes;
    }
    public void setFoodTypes(String foodTypes) {
        this.foodTypes = foodTypes;
    }

    public String getSchedule() {
        return schedule;
    }
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

}
