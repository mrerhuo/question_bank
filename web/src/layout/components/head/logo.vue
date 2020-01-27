<template>
  <div>
     <router-link to="/home" class="log_title">XXX后台管理系统</router-link>
  </div>
</template>
<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class Logo extends Vue {}
</script>
<style lang="less" scoped>
.log_title {
  font-size: 32px;
  color: #ffffff;
}
.log_title:link {
  color: #ffffff!important;
}
 /* 未被访问的链接 蓝色 */
.log_title:visited {
  color: #ffffff!important;
}
 /* 已被访问过的链接 蓝色 */
.log_title:hover {
  color: #ffffff!important;
}
 /* 鼠标悬浮在上的链接 蓝色 */
.log_title:active {
  color: #ffffff!important;
} /* 鼠标点中激活链接 蓝色 */
</style>