package com.sheila.restaurants_app.dao;

import com.sheila.restaurants_app.model.Address;

import java.util.List;

//Interface for complete abstraction, hiding details such as sql statements to be made in the JdbcDao classes
public interface AddressDao {

    //Abstract methods to be used in the AddressesController

    List<Address> getAddresses();

    Address getAddress(int addressId);

    void addAddress(Address addressToAdd);

    void deleteAddress(int addressId);

    void updateAddress(int addressId, Address addressToUpdate);

}
