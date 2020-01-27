<template>
  <div class="menu-layout">
    <side-menu v-show="!menu.mobile&&!menu.isOpen" />
    <min-menu v-show="!menu.mobile&&menu.isOpen" />
    <Drawer
      title="菜单"
      placement="left"
      @on-close="drawerClose"
      :closable="false"
      :value="menu.mobile&&!menu.isOpen"
    >
      <side-menu />
    </Drawer>
  </div>
</template>
<script lang="ts">
import { Component, Watch, Prop, Vue } from "vue-property-decorator";
import { AppModule, DeviceType } from "@/store/modules/app";
import SideMenu from "./SideMenu.vue";
import MinMenu from "./MinMenu.vue";
@Component({
  components: { SideMenu, MinMenu }
})
export default class MenuContainer extends Vue {
  get menu() {
    return {
      isOpen: !AppModule.menu.opened,
      mobile: AppModule.device === DeviceType.Mobile
    };
  }

  drawerClose() {
    AppModule.ToggleSideBar(false);
  }
}
</script>
<style scoped lang="less">
</style>