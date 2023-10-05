import axios from 'axios';

export default {
  //View a list of all locations and details for a specific restaurantId
  list(restaurantId) {
    return axios.get(`http://localhost:8080/api/addressesOfRestaurant/${restaurantId}`);
  },
  //View a specific restaurant and its specific location by addressId
  get(addressId) {
    return axios.get(`http://localhost:8080/api/address/${addressId}`);
  },
  //Add new location to existing restaurant
  create(address) {
    return axios.post('http://localhost:8080/api/addAddress', address);
  },
  //Update a specific location of a restaurant
  update(address) {
    return axios.put(
      `http://localhost:8080/api/updateAddress/${address.addressId}`,
      address
    );
  },
  //Delete a specific location of a restaurant
  delete(addressId) {
    return axios.delete(
      `http://localhost:8080/api/deleteAddress/${addressId}`
    );
  },
};
