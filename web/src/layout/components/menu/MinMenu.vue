<template>
  <div class="min_menu">
    <Dropdown placement="right-start">
      <a href="javascript:void(0)">
        <i class="ivu-icon ivu-icon-ios-checkmark min_menu_size" size="36"></i>
      </a>
      <DropdownMenu slot="list">
        <DropdownItem>驴打滚</DropdownItem>
        <DropdownItem>炸酱面</DropdownItem>
        <DropdownItem>豆汁儿</DropdownItem>
        <Dropdown placement="right-start">
          <DropdownItem>
            北京烤鸭
            <Icon type="ios-arrow-forward"></Icon>
          </DropdownItem>
          <DropdownMenu slot="list">
            <DropdownItem>挂炉烤鸭</DropdownItem>
            <DropdownItem>焖炉烤鸭</DropdownItem>
          </DropdownMenu>
        </Dropdown>
        <DropdownItem>冰糖葫芦</DropdownItem>
      </DropdownMenu>
    </Dropdown>
  </div>
</template>
<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";

@Component
export default class MinMenu extends Vue {}
</script>
<style scoped lang="less">
.min_menu{
  margin: 0 10px 0 10px;
}
.min_menu_size {
  font-size: 36px;
  background-color: red;
}
</style>