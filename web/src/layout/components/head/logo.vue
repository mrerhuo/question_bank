<template>
  <div>
     <el-link class="log_title" to='/home' :underline="false">XXX后台管理系统</el-link>
  </div>
</template>
<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class Logo extends Vue {
}
</script>
<style lang="scss" scoped>
.log_title{
    font-size: 32px;
    color: #ffffff;
}
</style>