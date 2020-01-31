<template>
  <Dropdown trigger="click"  @on-click="handleSetSize">
    <a href="javascript:void(0)">
      <i class="iconfont icon-zitidaxiao-da head_icon"></i>
      <Icon :size="18" style="color:#ffffff;" type="md-arrow-dropdown"></Icon>
    </a>
    <DropdownItem
      slot="list"
      v-for="item of sizeOptions"
      :key="item.value"
      :disabled="size===item.value"
      :name="item.value"
    >{{item.label }}</DropdownItem>
  </Dropdown>
</template>
<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { AppModule } from "@/store/modules/app";
@Component
export default class SetFontSize extends Vue {
  get size() {
    return AppModule.size;
  }
  private sizeOptions = [
    { label: "Large", value: "large" },
    { label: "Default", value: "default" },
    { label: "Small", value: "small" }
  ];
  handleSetSize(name: string) {
    AppModule.SetSize(name);
    this.refreshView();
    this.$Message.success("切换成功");
  }

  private refreshView() {
    const { fullPath } = this.$route;
    this.$nextTick(() => {
      this.$router.replace({ path:"/redirect"+fullPath});
    });
  }
}
</script>
<style lang="less" scoped>
</style>