<template>
  <body>
    <h2>Add new location to a restaurant.</h2>
    <div class="outer-wrapper">
      <div class="wrapper">
        <!-- When user submits this form, call saveAddress method -->
        <form action="#" v-on:submit.prevent="saveAddress">
          <!-- Prompt for address name -->
          <div class="field">
            <label>Address</label>
            <br />
            <input type="text" v-model="address.name" required />
          </div>
          <br />
          <!-- Prompt for food types -->
          <div class="field">
            <label>Food Types</label>
            <br />
            <input type="text" v-model="address.foodTypes" required />
          </div>
          <br />
          <!-- Prompt for schedule pdf url -->
          <div class="field">
            <label>Schedule(PDF URL)</label>
            <br />
            <input type="text" v-model="address.schedule" required />
          </div>
          <br />
          <!-- Prompt for restaurantId -->
          <div class="field">
            <label>RestaurantId</label>
            <br />
            <input type="text" v-model="address.restaurantId" required />
          </div>
          <br />
          <div class="field">
            <input type="submit" value="Add address" />
          </div>
        </form>
      </div>
    </div>
  </body>
</template>

<script>
import addressService from '@/services/AddressService';

export default {
  data() {
    return {
      address: {
        name: '',
      },
    };
  },
  methods: {
    saveAddress() {
      const newAddress = {
        name: this.address.name,
        foodTypes: this.address.foodTypes,
        schedule: this.address.schedule,
        restaurantId: this.address.restaurantId,
      };
      //Add to database and notify user success or failure
      addressService
        .create(newAddress)
        .then((response) => {
          if (response.status === 201) {
            alert('Address added!');
            this.$router.push('/display'); //Go back to all addresss page
          }
        })
        .catch((err) => {
          console.error(err + ' Problem adding address!');
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
h2 {
  padding: 2%;
}
</style>
