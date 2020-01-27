<template>
  <Tooltip content="布局大小" placement="bottom">
    <Dropdown trigger="click">
      <a href="javascript:void(0)">
        <i class="iconfont icon-zitidaxiao-da head_icon"></i>
        <Icon :size="18" style="color:#ffffff;" type="md-arrow-dropdown"></Icon>
      </a>
      <DropdownItem
        slot="list"
        v-for="item of sizeOptions"
        :key="item.value"
        :disabled="size===item.value"
        :command="item.value"
      >{{item.label }}</DropdownItem>
    </Dropdown>
  </Tooltip>
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
    { label: "Default", value: "default" },
    { label: "Medium", value: "medium" },
    { label: "Small", value: "small" },
    { label: "Mini", value: "mini" }
  ];
  private handleSetSize(size: string) {
    (this as any).$ELEMENT.size = size;
    AppModule.SetSize(size);
    this.refreshView();
    this.$Message.success("切换成功");
  }

  private refreshView() {
    const { fullPath } = this.$route;
    this.$nextTick(() => {
      this.$router.replace({
        path: fullPath
      });
    });
  }
}
</script>
<style lang="less" scoped>
</style>