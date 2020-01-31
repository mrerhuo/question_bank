<template>
  <div class="testbg">
    <logo style="float:left" v-show="isDeskTop" />
    <hamburger style="float:left" :is-active="menu.opened" @toggleClick="toggleMenu"></hamburger>
    <user-head style="float:right;" />
    
    <screen-full style="float:right;margin-right: 10px;" />
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
import { AppModule, DeviceType } from "@/store/modules/app";
import Logo from "./logo.vue";
import Hamburger from "./hamburger.vue";
import ScreenFull from "./ScreenFull.vue";
import SetFontSize from "./SetFontSize.vue";
import UserHead from "./UserHead.vue";
@Component({
  components: { Logo, Hamburger, ScreenFull, SetFontSize, UserHead }
})
export default class HeadBar extends Vue {
  get isDeskTop() {
    return AppModule.device === DeviceType.Desktop;
  }
  get menu() {
    return AppModule.menu;
  }
  toggleMenu() {
    AppModule.ToggleSideBar(false);
  }
}
</script>

<style lang="less" scoped>
.testbg {
  background-color: cadetblue;
  
}
</style>