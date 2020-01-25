<template>
  <el-container class="root_container">
    <el-header class="layout-head">
      <el-button @click="drawers" type="primary" style="margin-left: 16px;">点我打开</el-button>
    </el-header>
    <el-container class="layout-main">
       <menu-layout class="layout-menu" width="180px"/>
      <el-main>
        <router-view />
      </el-main>
    </el-container>
    <el-footer class="layout-footer">Footer</el-footer>
  </el-container>
</template>
<script lang="ts">
import { Component } from "vue-property-decorator";
import WindowResize from "./components/WindowResize";
import menuLayout from "./components/menu/index.vue";
@Component({
  components: { menuLayout }
})
export default class Layout extends WindowResize {

  // isShow = false;
  drawers() {
    if (!this.deviceType) {
      this.deviceType = true;
    } else {
      this.deviceType = false;
    }
  }
}
</script>
<style scoped lang="less">
.layout-head {
  background-color: blueviolet;
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