import Vue from 'vue'
import App from './App.vue'
import ViewUI from 'view-design'
import router from './router'
import store from './store'
import '@/style/theme.less';
// import '@/style/site.less'
import '@/style/iconfonts/iconfont.css'
import { AppModule } from '@/store/modules/app'

Vue.use(ViewUI,{
  size:AppModule.size
})

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
