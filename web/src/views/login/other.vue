<template>
  <Modal :value="value" title="第三方登录" :footer-hide="true" @on-visible-change="visibleChange">
    <i class="iconfont icon-weibiaoti9 other-login"></i>
    <i class="iconfont icon-wechat other-login"></i>
    <i class="iconfont icon-weibo other-login"></i>
    <i class="iconfont icon-taobao other-login"></i>
  </Modal>
</template>
<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
@Component
export default class OtherLogin extends Vue {
  @Prop({ type: Boolean, default: false }) value!: boolean;
  handleClose() {
    if (!this.value) {
      this.$emit("input", false);
    }
  }
  visibleChange(value: boolean) {
    if (!value) {
      this.$emit("input", value);
    }
  }
}
</script>

<style scoped lang="less">
.other-login {
  font-size: 42px;
}
</style>