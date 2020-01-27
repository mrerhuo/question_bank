<template>
  <div @click="toggleClick">
    <i v-show="isActive" class="iconfont icon-zhedie head_icon" />
    <i v-show="!isActive" class="iconfont icon-zhedie1 head_icon" />
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";

@Component
export default class Hamburger extends Vue {
  @Prop({ default: false }) private isActive!: boolean;

  private toggleClick() {
    this.$emit("toggleClick");
  }
}
</script>

<style lang="less" scoped>
</style>