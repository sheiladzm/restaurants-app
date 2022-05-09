package com.sheila.restaurants_app.dao;

import com.sheila.restaurants_app.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

//Houses connection and concrete methods to touch the database
public class RestaurantJdbcDao implements RestaurantDao {

    //Initiate JdbcTemplate to use queryForRowSet() and queryForObject() methods that take in sql statements
    private JdbcTemplate template;

    //Establish connection using DataSource
    public RestaurantJdbcDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    //Transform database row into an object

    private Restaurant mapRowToRestaurant(SqlRowSet result) {

        Restaurant retrievedRestaurant = new Restaurant();

        retrievedRestaurant.setRestaurantId(result.getInt("restaurant_id"));
        retrievedRestaurant.setName(result.getString("name"));

        return retrievedRestaurant;

    }

    //Get all restaurants from the database and build a list
    @Override
    public List<Restaurant> getRestaurants() {
        return null;
    }

    //Get a specific restaurant from the database
    @Override
    public Restaurant getRestaurant(int restaurantId) {
        return null;
    }

    //Add a new restaurant to the database
    @Override
    public void addRestaurant(Restaurant restaurantToAdd) {

    }

    //Delete a specific restaurant from the database
    @Override
    public void deleteRestaurant(int restaurantId) {

    }

    //Update a specific restaurant from the database
    @Override
    public void updateRestaurant(int restaurantId, Restaurant restaurantToUpdate) {

    }

}
