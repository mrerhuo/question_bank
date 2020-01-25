<template>
  <div>
    <el-dialog title="第三方登录" :visible.sync="value" width="30%" :before-close="handleClose">
      <el-row>
        <i class="iconfont icon-weibiaoti9 other-login"></i>
        <i class="iconfont icon-wechat other-login"></i>
        <i class="iconfont icon-weibo other-login"></i>
        <i class="iconfont icon-taobao other-login"></i>
      </el-row>
    </el-dialog>
  </div>
</template>
<script lang="ts">
import {Component, Prop, Vue } from "vue-property-decorator";
@Component
export default class OtherLogin extends Vue{
    @Prop({type:Boolean,default:false}) value:boolean;

    handleClose() {
      this.$emit("input", false);
    }
}
</script>

<style scoped lang="less">
.other-login{
    font-size: 42px;
}
</style>