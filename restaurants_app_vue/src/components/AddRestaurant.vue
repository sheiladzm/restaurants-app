<template>
  <body>
    <h2>Add new restaurant.</h2>
    <div class="outer-wrapper">
      <div class="wrapper">
        <!-- When user submits this form, call saveRestaurant method -->
        <form action="#" v-on:submit.prevent="saveRestaurant">

          <!-- Prompt for restaurant name -->
          <div class="field">
            <label>Name</label>
            <br />
            <input type="text" v-model="restaurant.name" required />
          </div>
          <br />
          <div class="field">
            <input type="submit" value="Add restaurant" />

          </div>
        </form>
      </div>
    </div>
  </body>
</template>

<script>
import restaurantService from '@/services/RestaurantService';

export default {
  data() {
    return {
      restaurant: {
        name: '',
      },
    };
  },
  methods: {
    saveRestaurant() {

      console.log('Saving restaurant');

          const newRestaurant = {
            name: this.restaurant.name,
          };

          //Add to database and notify user success or failure
          restaurantService
            .create(newRestaurant)
            .then((response) => {
              if (response.status === 201) {
                alert('Restaurant added!');
                this.$router.push('/display'); //Go back to all restaurants page
              }
            })
            .catch((err) => {
              console.error(err + ' Problem adding restaurant!');
            });
    },
  },
};
</script>

<style scoped>

body {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  padding-top: 5%;
  padding-bottom: 20%;
}

.wrapper {
  border: 1px solid;
  padding: 20%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  width: 200px;
}

</style>
