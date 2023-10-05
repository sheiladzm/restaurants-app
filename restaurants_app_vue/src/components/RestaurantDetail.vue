<template>
  <div class="restaurant-detail-parent">
    <div class="restaurant-detail">
    <h2>This is the restaurant you selected: {{ restaurant.name }} </h2>
    <br />
    <button id="update-rest-btn" v-on:click="updateRestaurant">
      Update Restaurant
    </button>
    <!-- When user checks box, call deleteRestaurant method alert to ensure deletion -->
          <b>Delete Restaurant</b>
          <input
            type="checkbox"
            v-bind:id="restaurant.restaurantId"
            v-on:change="deleteRestaurant($event)"
          />
    </div>
    <h3>These are its locations with their details:</h3> <br />
    <!-- Loop through every item in the list of addresses of this specific restaurant -->
     <div class="addresses" v-for="address in addresses" :key="address.addressId">
        <!-- Then display address details on each iteration -->
        <div class="address-text">
          <b>Address:</b> {{ address.name }}
          <br /><br />
          <b>Food Types:</b> {{ address.foodTypes }}
          <br /><br />
          <b>Schedule:</b> {{ address.schedule }}
          <br /><br />
          <b>RestaurantId:</b> {{ address.restaurantId }}
          <br /><br />
          <div class="update-form">
            <!-- When user submits this form, call updateAddress method -->
            <form action="#" v-on:submit.prevent="updateAddress">
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
              <input type="submit" value="Update Location" />
              </div>
            </form>
          <!-- When user checks box, call deleteAddress method alert to ensure deletion -->
          <br /><br />
          <b>Delete Address</b>
          <input
            type="checkbox"
            v-bind:id="address.addressId"
            v-on:change="deleteAddress($event)"
          />
          </div>
        </div>
      </div>
  </div>
</template>

<script>
import restaurantService from '../services/RestaurantService';
import addressService from '../services/AddressService';

export default {
  props: {
    restaurantId: Number,
  },
  data() {
    return {
      restaurant: {
        name: '',
        foodTypes: '',
        schedule: '',
        restaurantId: '',
      },
    };
  },
  created() {
    restaurantService.get(this.$route.params.id).then((restaurantData) => {
      this.restaurant = restaurantData.data;
    });
    addressService
      .list(this.$route.params.id)
      .then((res) => {
          this.addresses = res.data;
        })
        .catch((err) => {
          console.error(err + ' Missing this address ');
        });
  },
  methods: {
    updateRestaurant() {
      const newRestaurant = {
        restaurantId: this.$route.params.id,
        name: this.restaurant.name,
      };
      restaurantService
        .update(newRestaurant)
        .then((response) => {
          if (response.status === 200) {
            alert('Restaurant updated!');
            this.$router.push('/display');
          }
        })
        .catch((err) => {
          console.error(err + ' Problem updating restaurant!');
        });
    },
    deleteRestaurant(event) {
      if (
        confirm(
          'Are you sure you want to delete this restaurant?  This action cannot be undone.'
        )
      ) {
        if (event.target.checked) {
          this.restaurantToDelete = {
            id: event.target.id,
          };
          restaurantService
            .delete(this.restaurantToDelete.id)
            .then((response) => {
              if (response.status === 200) {
                alert('Restaurant was deleted!');
              }
              window.location.reload(); //Reload this page after deletion
            })
            .catch((error) => {
              if (error.response) {
                this.errorMsg =
                  "Error deleting restaurant. Response received was '" +
                  error.response.statusText +
                  "'.";
              } else if (error.request) {
                this.errorMsg = 'Server could not be reached.';
              } else {
                this.errorMsg = 'Request could not be created.';
              }
            });
        } else {
          this.oneToConvert = {};
        }
      }
    },
    updateAddress() {
      const newAddress = {
        addressId: this.$route.params.id,
        name: this.address.name,
        foodTypes: this.address.foodTypes,
        schedule: this.address.schedule,
      };
      addressService
        .update(newAddress)
        .then((response) => {
          if (response.status === 200) {
            alert('Location updated!');
            this.$router.push('/displayaddress/:id');
          }
        })
        .catch((err) => {
          console.error(err + ' Problem updating location!');
        });
    },
    deleteAddress(event) {
      if (
        confirm(
          'Are you sure you want to delete this location?  This action cannot be undone.'
        )
      ) {
        if (event.target.checked) {
          this.addressToDelete = {
            id: event.target.id,
          };
          addressService
            .delete(this.addressToDelete.id)
            .then((response) => {
              if (response.status === 200) {
                alert('Address was deleted!');
              }
              window.location.reload(); //Reload this page after deletion
            })
            .catch((error) => {
              if (error.response) {
                this.errorMsg =
                  "Error deleting address. Response received was '" +
                  error.response.statusText +
                  "'.";
              } else if (error.request) {
                this.errorMsg = 'Server could not be reached.';
              } else {
                this.errorMsg = 'Request could not be created.';
              }
            });
        } else {
          this.oneToConvert = {};
        }
      }
    },
  },
};
</script>

<style scoped>
.restaurant-detail-parent {
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 5%;
  flex-direction: column;
}
.restaurant-detail {
  margin: 5%;
  text-align: center;
}
#update-address-btn, #update-rest-btn {
  margin: 2%;
}
.address-text {
  text-align: left;
  border: 1px solid black;
  margin: 2%;
  padding: 5%;
}
</style>
