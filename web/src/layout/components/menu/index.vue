<template>
  <div class="menu-layout">
    <div class="side_menu" :style="{ height: pageHeight - 129 + 'px' }">
      <side-menu
        :menu-data="menu.menuList"
        v-show="!menu.mobile && !menu.isOpen"
      />
      <min-menu
        :menu-data="menu.menuList"
        v-show="!menu.mobile && menu.isOpen"
      />
    </div>

    <!---小屏幕的时候显示菜单-->
    <Drawer
      class="cus_drawer"
      title="菜单"
      placement="left"
      @on-close="drawerClose"
      :closable="false"
      :value="menu.mobile && !menu.isOpen"
    >
      <side-menu :menu-data="menu.menuList" />
    </Drawer>
  </div>
</template>
<style lang="less">
.side_menu {
  overflow-y: auto;
}
</style>
<script lang="ts">
import { Component, Watch, Prop, Vue } from "vue-property-decorator";
import { AppModule, DeviceType } from "@/store/modules/app";
import SideMenu from "./SideMenu.vue";
import MinMenu from "./MinMenu.vue";
@Component({
  components: { SideMenu, MinMenu }
})
export default class MenuContainer extends Vue {
  get pageHeight() {
    return AppModule.height;
  }
  get menu() {
    return {
      isOpen: !AppModule.menu.opened,
      mobile: AppModule.device === DeviceType.Mobile,
      menuList: AppModule.menuList
    };
  }

  drawerClose() {
    AppModule.ToggleSideBar(false);
  }
}
</script>
<style scoped lang="less"></style>
