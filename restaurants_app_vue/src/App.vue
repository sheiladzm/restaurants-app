<!-- Nav bar styling and links -->

<template>
  <div id="app">
    <div id="nav">
      <li>
        <router-link
          v-bind:to="{ name: 'display' }"
          
          >All Restaurants</router-link
        >
      </li>

      <li>
        <router-link
          v-bind:to="{ name: 'add' }"
          
          >Add Restaurants</router-link
        >
      </li>

      <li>
        <router-link
          v-bind:to="{ name: 'add2' }"
          
          >Add Address</router-link
        >
      </li>
      <router-view />
    </div>
  </div>
</template>

<style scoped>
#nav {
  padding: 0;
  background: black;
  height: 5vh;
}

li {
  display: inline-block;
}

a {
  display: block;
  padding: 10px;
  font-size: 14px;
  text-transform: uppercase;
  color: white
}
</style>
