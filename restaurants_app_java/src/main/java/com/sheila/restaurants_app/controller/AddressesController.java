package com.sheila.restaurants_app.controller;

import com.sheila.restaurants_app.dao.AddressDao;
import com.sheila.restaurants_app.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

//API Controller that receives incoming web requests and calls methods that retrieve/manipulate data

@RestController
@RequestMapping("/api") //Root path
@CrossOrigin
public class AddressesController {

    @Autowired
    AddressDao theAddress;

    //Log timestamp of request to Console
    static void logTimestamp(String msg) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(msg + " at " + timestamp);
    }

    //View all locations
    @GetMapping(path= {"/allAddresses", "/"})
    public List<Address> getAllAddresses()  {

        logTimestamp("Getting all addresses");
        List<Address> allAddresses = theAddress.getAddresses();
        return allAddresses;

    }

    //View all restaurants and their locations
//    @GetMapping(path= {"/allAddressesAndRestaurants", "/"})
//    public List<Address> getAllAddressesAndRestaurants()  {
//
//        logTimestamp("Getting all restaurants with their addresses");
//        List<Address> allAddressesAndRestaurants = theAddress.getAddressesWithRestaurants();
//        return allAddressesAndRestaurants;
//
//    }

    //View a specific location of a restaurant
    @GetMapping("/address/{addressId}")
    public Address getAddressById(@PathVariable int addressId) {

        logTimestamp("Returning address " + addressId);
        Address address = theAddress.getAddress(addressId);
        return address;

    }

    @GetMapping("/addressesOfRestaurant/{restaurantId}")
    public List<Address> getAddressesByRestaurantId(@PathVariable int restaurantId) {

        logTimestamp("Returning addresses for restaurant # " + restaurantId);
        List<Address> addresses = theAddress.getAddressesByRestaurant(restaurantId);
        return addresses;

    }

    //View a specific location of a restaurant and its restaurant name, address, food, schedule
//    @GetMapping("/addressAndRestaurant/{addressId}")
//    public Address getAddressAndRestaurantById(@PathVariable int addressId) {
//
//        logTimestamp("Returning restaurant detail for location # " + addressId);
//        Address addressById = theAddress.getAddressMoreDetails(addressId);
//        return addressById;
//
//    }

    //Add new location to existing restaurant
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addAddress")
    public void addNewAddress(@RequestBody Address newAddress){
        theAddress.addAddress(newAddress);
        logTimestamp("Adding new location:" + newAddress.getName());
    }

    //Update a specific location of a restaurant
    @PutMapping("/updateAddress/{addressId}")
    public void updateAddressById(@PathVariable int addressId, @RequestBody Address addressToUpdate) {
        logTimestamp("Updating this location: " + addressId);
        theAddress.updateAddress(addressId, addressToUpdate);
    }

    //Delete a specific location only (not the restaurant)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteAddress/{addressId}")
    public void deleteAddressById(@PathVariable int addressId) {
        theAddress.deleteAddress(addressId);
        logTimestamp("Removing this location " + addressId);
    }

}
