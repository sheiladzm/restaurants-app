package com.sheila.restaurants_app.dao;

import com.sheila.restaurants_app.model.Restaurant;
import java.util.List;

//Interface for complete abstraction, hiding details such as sql statements to be made in the JdbcDao classes
public interface RestaurantDao {

    List<Restaurant> getRestaurants();

    Restaurant getRestaurant(int restaurantId);

    void addRestaurant(Restaurant restaurantToAdd);

    void deleteRestaurant(int restaurantId);

    void updateRestaurant(int restaurantId, Restaurant restaurantToUpdate);
}
