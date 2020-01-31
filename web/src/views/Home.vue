<template>
  <div class="root_container" :style="{ height: pageHeight + 'px'}">首页</div>
</template>
<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
@Component
export default class Home extends Vue {
  pageHeight = Vue.prototype.$height - 133; //空白页为：133查询条件一行：237 查询条件2行269
}
</script>
<style scoped lang="less">
.home_bg {
  background-color: cornflowerblue;
}
</style>