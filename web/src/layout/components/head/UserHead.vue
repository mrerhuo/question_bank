<template>
  <div>
    <Dropdown trigger="click">
      <Avatar
        shape="square"
        size="large"
        src="https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80"
      />
      <Icon :size="18" style="color:#ffffff;" type="md-arrow-dropdown"></Icon>
      <DropdownMenu slot="list">
        <DropdownItem name="message">
          <router-link to="/sys/userinfo" class="min_item_link">个人中心</router-link>
        </DropdownItem>
        <DropdownItem name="message">首页</DropdownItem>
        <DropdownItem name="message">设置</DropdownItem>
        <DropdownItem divided name="logout">退出登录</DropdownItem>
      </DropdownMenu>
    </Dropdown>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class UserHead extends Vue {
  logout() {
    console.log("退出");
  }
}
</script>
<style lang="less">
</style>