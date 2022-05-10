package com.sheila.restaurants_app.dao;

import com.sheila.restaurants_app.exceptions.RestaurantNotFoundException;
import com.sheila.restaurants_app.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

//Houses connection and concrete methods to touch the database - restaurants table
@Component
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

    //Get all restaurants with their addresses from the database and build a list
    @Override
    public List<Restaurant> getRestaurantsWithAddresses() {

        List<Restaurant> restaurantListWithAddresses = new ArrayList<>();

        String sql = "select restaurants.name, addresses.name\n" +
                "from addresses\n" +
                "left join restaurants on restaurants.restaurant_id = addresses.restaurant_id\n" +
                "group by restaurants.name, addresses.name\n" +
                "order by restaurants.name;";
        SqlRowSet results = template.queryForRowSet(sql);
        while (results.next()) {
            restaurantListWithAddresses.add(mapRowToRestaurant(results));
        }

        return restaurantListWithAddresses;

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

        String sql = "delete from restaurants where restaurant_id = ?; delete from addresses";
        template.update(sql, restaurantId);

    }

    //Update a specific restaurant from the database
    @Override
    public void updateRestaurant(int restaurantId, Restaurant restaurantToUpdate) {

        String sql = "update restaurants set name = ?";
        template.update(sql, restaurantToUpdate.getName());

    }

}
