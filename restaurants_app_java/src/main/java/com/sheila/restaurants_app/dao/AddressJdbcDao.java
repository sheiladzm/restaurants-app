package com.sheila.restaurants_app.dao;

import com.sheila.restaurants_app.model.Address;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

//Houses connection and concrete methods to touch the database - addresses table
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
        return null;
    }

    //Get a specific address from the database
    @Override
    public Address getAddress(int addressId) {
        return null;
    }

    //Add a new address to the database
    @Override
    public void addAddress(Address addressToAdd) {

    }

    //Delete a specific address from the database
    @Override
    public void deleteAddress(int addressId) {

    }

    //Update a specific address from the database
    @Override
    public void updateAddress(int addressId, Address addressToUpdate) {

    }

}
