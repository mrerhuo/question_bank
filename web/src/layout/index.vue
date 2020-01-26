<template>
  <el-container class="root_container">
    <el-header class="layout-head">
      <div>
      <logo style="float:left"/>
        <hamburger style="float:left" :is-active="menu.opened" @toggleClick="toggleMenu"></hamburger>
        <screen-full style="float:left"/>
      </div>
    </el-header>
    <el-container class="layout-main">
      <menu-layout class="layout-menu" width="180px" />
      <el-main>
        <router-view />
      </el-main>
    </el-container>
    <el-footer class="layout-footer">Footer</el-footer>
  </el-container>
</template>
<script lang="ts">
import { Component } from "vue-property-decorator";
import { AppModule } from "@/store/modules/app";
import WindowResize from "./components/WindowResize";
import menuLayout from "./components/menu/index.vue";
import { Logo,Hamburger, ScreenFull } from "./components/head/";
@Component({
  components: { menuLayout,Logo, Hamburger, ScreenFull }
})
export default class Layout extends WindowResize {
  get menu() {
    return AppModule.menu;
  }
  toggleMenu() {
    AppModule.ToggleSideBar(false);
  }
}
</script>
<style scoped lang="scss">
.layout-head {
  background-color: #545c64;
}
.layout-footer {
  background-color: red;
}
.layout-main {
  height: 100%;
  background-color: yellow;
}
.layout-menu {
  background-color: chocolate;
}
</style>