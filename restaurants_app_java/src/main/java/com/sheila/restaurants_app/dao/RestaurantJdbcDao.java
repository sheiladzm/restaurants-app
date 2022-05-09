package com.sheila.restaurants_app.dao;

import com.sheila.restaurants_app.exceptions.RestaurantNotFoundException;
import com.sheila.restaurants_app.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

//Houses connection and concrete methods to touch the database - restaurants table
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

        List<Restaurant> restaurantList = new ArrayList<>();

        String sql = "select * from restaurants";
        SqlRowSet results = template.queryForRowSet(sql);
        while (results.next()) {
            restaurantList.add(mapRowToRestaurant(results));
        }

        return restaurantList;

    }

    //Get a specific restaurant from the database
    @Override
    public Restaurant getRestaurant(int restaurantId) {

        Restaurant restaurant;

        String sql = "select * from restaurants where restaurant_id = ?";
        SqlRowSet result = template.queryForRowSet(sql, restaurantId);
        if (result.next()) {
            restaurant = mapRowToRestaurant(result);
        }
        else {
            throw new RestaurantNotFoundException();
        }

        return restaurant;

    }

    //Add a new restaurant to the database
    @Override
    public void addRestaurant(Restaurant restaurantToAdd) {

        String sql = "insert into restaurants (name) values (?)";
        template.update(sql, restaurantToAdd.getName());

    }

    //Delete a specific restaurant from the database
    @Override
    public void deleteRestaurant(int restaurantId) {

        String sql = "delete from restaurants where restaurant_id = ?";
        template.update(sql, restaurantId);

    }

    //Update a specific restaurant from the database
    @Override
    public void updateRestaurant(int restaurantId, Restaurant restaurantToUpdate) {

        String sql = "update restaurants set name = ?";
        template.update(sql, restaurantToUpdate.getName());

    }

}
