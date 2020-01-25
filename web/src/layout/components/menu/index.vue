<template>
  <div class="menu-layout">
    <el-drawer
      size="179px"
      title="菜单"
      :show-close="false"
      :append-to-body="true"
      :visible.sync="menu.mobile&&menu.isOpen"
      direction="ltr"
    >
      <menus />
    </el-drawer>
    <el-aside class="layout-menu" v-show="!menu.mobile&&!menu.isOpen" width="180px">
      <menus />
    </el-aside>
  </div>
</template>
<script lang="ts">
import { Component, Watch, Prop, Vue } from "vue-property-decorator";
import { AppModule, DeviceType } from "@/store/modules/app";
import Menus from "./menu.vue";

@Component({
  components: { Menus }
})
export default class MenuLayout extends Vue {
  get menu() {
    return {
      isOpen: AppModule.menu.opened,
      mobile: AppModule.device === DeviceType.Mobile
    };
  }
}
</script>
<style scoped lang="less">
.menu-layout {
  height: 100%;
  overflow-x: hidden; /*x轴禁止滚动*/
  overflow-y: scroll; /*y轴滚动*/
}
.ccc {
  z-index: "2006";
}
</style>