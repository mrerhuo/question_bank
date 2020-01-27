import Vue from 'vue'
import App from './App.vue'
import ViewUI from 'view-design'
import router from './router'
import store from './store'
import '@/style/theme.less';
import '@/style/site.css'
import '@/style/iconfonts/iconfont.css'

Vue.use(ViewUI)
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
