import Vue from 'vue';
import Router from 'vue-router';
import Display from '../views/Display.vue';
import Add from '../views/Add.vue';
import Add2 from '../views/Add2.vue';
import Detail from '../views/Detail.vue';

Vue.use(Router);

//Direct to components and views

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/display',
      name: 'display',
      component: Display,
    },
    {
      path: '/displayrestaurant/:id',
      name: 'display-restaurant-detail',
      component: Detail,
    },
    {
      path: '/add',
      name: 'add',
      component: Add,
    },
    {
      path: '/add2',
      name: 'add2',
      component: Add2,
    },
  ],
});

export default router;
