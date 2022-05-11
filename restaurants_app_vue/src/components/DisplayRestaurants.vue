<template>
  <div id="restaurants-parent">
    <h2>ALL RESTAURANTS</h2>
    <div class="restaurantInfo">

      <!-- Loop through every item in the list of restaurants and restaurants -->
      <div class="restaurants" v-for="restaurant in restaurants" :key="restaurant.restaurantId">

        <!-- Then display restaurant name and restaurant name on each iteration -->
        <div class="restaurant-text">
          <h3>{{ restaurant.name }} </h3>
        <!-- Calling dynamic route to link the specific restaurant and a link to its specific locations -->
         <ul>
          <li>
            <router-link
              :to="{
                name: 'display-restaurant-detail',
                params: { id: restaurant.restaurantId },
              }"
              >View Details</router-link
            >
          </li>
        </ul>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
import restaurantService from '@/services/RestaurantService';

export default {
  data() {
    return { restaurants: [] };
  },

  created() {
    restaurantService
      .list()
      .then((res) => {
        this.restaurants = res.data;
      })
      .catch((err) => {
        console.error(err + ' Missing this restaurant ');
      });
  },
};
</script>

<style scoped>

h2 {
  text-align: center;
  padding-top: 2em;
  padding-bottom: 2em;
}

a {
  color: black;
}
.restaurant-text {
  padding: 2%;
  align-items: center;
  text-align: left;
  border: 1px solid black;
  margin: 2%;
}
</style>
