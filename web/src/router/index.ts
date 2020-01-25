import Vue from 'vue'
import VueRouter from 'vue-router'
import { routers } from './router';
Vue.use(VueRouter)

// const routes = [
//   {
//     path: '/',
//     name: 'home',
//     component: Home
//   },
//   {
//     path: '/about',
//     name: 'about',
//     // route level code-splitting
//     // this generates a separate chunk (about.[hash].js) for this route
//     // which is lazy-loaded when the route is visited.
//     component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
//   }
// ]

const router = new VueRouter({
  mode: 'history',
  scrollBehavior: (to, from, savedPosition) => {
    return { x: 0, y: 0 }
  },
  routes: routers
})

export default router
//路由开始方法
router.beforeEach((to, from, next) => {
  next();
});