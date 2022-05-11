import axios from 'axios';

// const http = axios.create({
//   baseURL: 'http://localhost:8080/api',
// });

export default {

  //View all restaurants
  list() {
    return axios.get('http://localhost:8080/api/allRestaurants/');
  },

  //View a specific restaurant
  get(restaurantId) {
    return axios.get(`http://localhost:8080/api/restaurant/${restaurantId}`);
  },
  
  //Add new restaurant
  create(restaurant) {
    return axios.post('http://localhost:8080/api/addRestaurant', restaurant);
  },

  //Update restaurant name
  update(restaurant) {
    return axios.put(
      `http://localhost:8080/api/updateAddress/${restaurant.restaurantId}`,
      restaurant
    );
  },

};
