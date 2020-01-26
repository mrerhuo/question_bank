<template>
  <div class="menu-layout">
    <el-aside
    class="menu-layout"
    v-show="!menu.mobile" :width="menu.isOpen?'65px':'180px'">
      <menus v-model="menu.isOpen" />
    </el-aside>
    <el-drawer
      size="179px"
      title="菜单"
      :show-close="false"
      :append-to-body="true"
      :visible.sync="menu.mobile&&!menu.isOpen"
      :before-close="drawerClose"
      direction="ltr"
    >
    <div class="menu-layout">
       <menus />
    </div>
    </el-drawer>
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
      isOpen: !AppModule.menu.opened,
      mobile: AppModule.device === DeviceType.Mobile
    };
  }
  drawerClose(done) {
    AppModule.ToggleSideBar(false);
  }
}
</script>
<style scoped lang="scss">
.menu-layout {
  height: 100%;
  transition: margin-left .28s;
  overflow-x: hidden; /*x轴禁止滚动*/
   overflow-y: auto;
}
.ccc {
  z-index: "2006";
}
</style>