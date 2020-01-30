<template>
  <Layout class="root_container">
    <Header class="layout_head">
      <layout-head />
    </Header>
    <Layout>
      <Sider
        class="layout_menu"
        v-show="!menu.mobile"
        hide-trigger
        collapsible
        :collapsed-width="56"
        :value="menu.isOpen"
      >
        <menu-container />
      </Sider>
      <Content>
        <layout-breadcrumb />
        <router-view />
      </Content>
    </Layout>
    <layout-footer class="layout_footer" />
  </Layout>
</template>
<script lang="ts">
import { Component, Watch } from "vue-property-decorator";
import { AppModule, DeviceType } from "@/store/modules/app";
import { RouteRecord, Route } from "vue-router";
import WindowResize from "./components/WindowResize";
import MenuContainer from "./components/menu/index.vue";
import LayoutHead from "./components/head/index.vue";
import LayoutFooter from "./components/footer/index.vue";
import LayoutBreadcrumb from "./components/breadcrumb/index.vue";
@Component({
  components: { MenuContainer, LayoutHead, LayoutFooter, LayoutBreadcrumb }
})
export default class DesignLayout extends WindowResize {
  @Watch("$route")
  private onRouteChange() {
    this.getBreadcrumb();
  }
  getBreadcrumb() {
    let matched = this.$route.matched.filter(item => item.name);
    let first = matched[0];
    if (first && first.name !== "layout") {
      matched = [
        {
          path: "/home",
          name: "home",
          meta: {
            isNav: true,
            title: "首页",
            icon: "ivu-icon ivu-icon-ios-home"
          }
        } as RouteRecord
      ].concat(matched);
    } else {
      matched.splice(0, 1);
    }
    AppModule.setBreadcrumb(matched);
  }
  created() {
    this.getBreadcrumb();
  }
}
</script>
<style scoped lang="less">
</style>