package com.sheila.restaurants_app.dao;

import com.sheila.restaurants_app.model.Address;
import java.util.List;

//Interface for complete abstraction, hiding details such as sql statements to be made in the JdbcDao classes
public interface AddressDao {

    List<Address> getAddresses();

    List<Address> getAddressesByRestaurant(int restaurantId);

    Address getAddress(int addressId);

    void addAddress(Address addressToAdd);

    void deleteAddress(int addressId);

    void updateAddress(int addressId, Address addressToUpdate);
}
