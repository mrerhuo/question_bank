<template>
  <Layout class="root_container">
    <Header>
      <head-bar />
    </Header>
    <Layout>
      <Sider v-show="!menu.mobile" hide-trigger collapsible :collapsed-width="56" :value="menu.isOpen">
        <menu-container />
      </Sider>
      <Content>
        <router-view />
      </Content>
    </Layout>
    <Footer class="layout_footer">Footer</Footer>
  </Layout>
</template>
<script lang="ts">
import { Component } from "vue-property-decorator";
import { AppModule, DeviceType } from "@/store/modules/app";
import WindowResize from "./components/WindowResize";
import MenuContainer from "./components/menu/index.vue";
import HeadBar from "./components/head/index.vue";
@Component({
  components: { MenuContainer,HeadBar }
})
export default class DesignLayout extends WindowResize {
  // Sider: any;
  // collapsedSider() {
  //   (this.$refs.side1 as any).toggleCollapse();
  // }
}
</script>
<style scoped lang="less">
.layout_head {
  background-color: rgb(48, 65, 86);
}
.layout_footer {
  background-color: rgb(116, 41, 41);
}
.layout_main {
  height: 100%;
  background-color: yellow;
}
.layout-menu {
  background-color: chocolate;
}
</style>