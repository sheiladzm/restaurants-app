package com.sheila.restaurants_app.controller;

import com.sheila.restaurants_app.dao.RestaurantDao;
import com.sheila.restaurants_app.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

//API Controller that receives incoming web requests and calls methods that retrieve/manipulate data

@RestController
@RequestMapping("/api") //Root path
public class RestaurantsController {

    @Autowired
    RestaurantDao theRestaurant;

    //Log timestamp of request to Console
    static void logTimestamp(String msg) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(msg + " at " + timestamp);
    }

//    //View all restaurants (names and their addresses)
//    @GetMapping(path= {"/allRestaurants", "/"})
//    public List<Restaurant> getAllRestaurantsWithAddresses()  {
//
//        logTimestamp("Getting all restaurants and their addresses");
//        List<Restaurant> allRestaurants = theRestaurant.getRestaurantsWithAddresses();
//        return allRestaurants;
//
//    }

    //View all restaurants (names only)
    @GetMapping(path= {"/allRestaurantsOnly", "/"})
    public List<Restaurant> getAllRestaurants()  {

        logTimestamp("Getting all restaurants");
        List<Restaurant> allRestaurantsOnly = theRestaurant.getRestaurants();
        return allRestaurantsOnly;

    }

    //View a specific restaurant
    @GetMapping("/restaurant/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable int restaurantId) {

        logTimestamp("Returning restaurant " + restaurantId);
        Restaurant restaurant = theRestaurant.getRestaurant(restaurantId);
        return restaurant;

    }

    //Add new restaurant (name only)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addRestaurant")
    public void addNewRestaurant(@RequestBody Restaurant newRestaurant){
        theRestaurant.addRestaurant(newRestaurant);
        logTimestamp("Adding new restaurant:" + newRestaurant.getName());
    }

    //Update restaurant (name only)
    @PutMapping("/updateRestaurant/{restaurantId}")
    public void updateRestaurantById(@PathVariable int restaurantId, @RequestBody Restaurant restaurantToUpdate) {
        logTimestamp("Updating this restaurant: " + restaurantId);
        theRestaurant.updateRestaurant(restaurantId, restaurantToUpdate);
    }

    //Delete a specific restaurant (will also delete its addresses from addresses table)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteRestaurant/{restaurantId}")
    public void deleteRestaurantById(@PathVariable int restaurantId) {
        theRestaurant.deleteRestaurant(restaurantId);
        logTimestamp("Removing restaurant " + restaurantId);
    }

}
