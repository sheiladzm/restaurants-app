package com.sheila.restaurants_app.dao;

import com.sheila.restaurants_app.exceptions.AddressNotFoundException;
import com.sheila.restaurants_app.model.Address;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

//Houses connection and concrete methods to touch the database - addresses table
@Component
public class AddressJdbcDao implements AddressDao {

    //Initiate JdbcTemplate to use queryForRowSet() and queryForObject() methods that take in sql statements
    private JdbcTemplate template;

    //Establish connection using DataSource
    public AddressJdbcDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    //Transform database row into an object
    private Address mapRowToAddress(SqlRowSet result) {
        Address retrievedAddress = new Address();
        retrievedAddress.setAddressId(result.getInt("address_id"));
        retrievedAddress.setName(result.getString("name"));
        retrievedAddress.setFoodTypes(result.getString("food_types"));
        retrievedAddress.setSchedule(result.getString("schedule"));
        retrievedAddress.setRestaurantId(result.getInt("restaurant_id"));
        return retrievedAddress;
    }

    //Get all addresses from the database and build a list
    @Override
    public List<Address> getAddresses() {
        List<Address> addressList = new ArrayList<>();
        String sql = "select * from addresses";
        SqlRowSet results = template.queryForRowSet(sql);
        while (results.next()) {
            addressList.add(mapRowToAddress(results));
        }
        return addressList;
    }

    @Override
    public List<Address> getAddressesByRestaurant(int restaurantId) {
        List<Address> addressList = new ArrayList<>();
        String sql = "select * from addresses where restaurant_id = ?";
        SqlRowSet results = template.queryForRowSet(sql, restaurantId);
        while (results.next()) {
            addressList.add(mapRowToAddress(results));
        }
        return addressList;
    }

    //Get a specific address from the database
    @Override
    public Address getAddress(int addressId) {
        Address address;
        String sql = "select * from addresses where address_id = ?";
        SqlRowSet result = template.queryForRowSet(sql, addressId);
        if (result.next()) {
            address = mapRowToAddress(result);
        }
        else {
            throw new AddressNotFoundException();
        }
        return address;
    }

    //Add a new address to the database
    @Override
    public void addAddress(Address addressToAdd) {
        String sql = "insert into addresses (name, food_types, schedule, restaurant_id) values (?, ?, ?, ?)";
        template.update(sql, addressToAdd.getName(), addressToAdd.getFoodTypes(), addressToAdd.getSchedule(), addressToAdd.getRestaurantId());
    }

    //Delete a specific address from the database
    @Override
    public void deleteAddress(int addressId) {
        String sql = "delete from addresses where address_id = ?";
        template.update(sql, addressId);
    }

    //Update a specific address from the database
    @Override
    public void updateAddress(int addressId, Address addressToUpdate) {
        String sql = "update addresses set name = ?, food_types = ?, schedule = ?, restaurant_id = ?";
        template.update(sql, addressToUpdate.getName(), addressToUpdate.getFoodTypes(), addressToUpdate.getSchedule(), addressToUpdate.getRestaurantId());
    }
}
