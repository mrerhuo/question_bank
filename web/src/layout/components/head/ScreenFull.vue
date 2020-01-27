<template>
  <Tooltip content="全屏" placement="bottom">
    <div id="screenfull" @click="click">
      <i v-show="!isFullscreen" class="iconfont icon-quanping head_icon" />
      <i v-show="isFullscreen" class="iconfont icon-jichucaozuoicon-tuichuquanping head_icon" />
    </div>
  </Tooltip>
</template>

<script lang="ts">
import screenfull from "screenfull";
import { Component, Vue } from "vue-property-decorator";

const sf = screenfull;

@Component
export default class ScreenFull extends Vue {
  private isFullscreen = false;

  mounted() {
    if (sf.isEnabled) {
      sf.on("change", this.change);
    }
  }

  beforeDestory() {
    if (sf.isEnabled) {
      sf.off("change", this.change);
    }
  }

  private change() {
    if (sf.isEnabled) {
      this.isFullscreen = sf.isFullscreen;
    }
  }

  private click() {
    if (!sf.isEnabled) {
      this.$Message.error("浏览器不兼容！");
      return false;
    }
    sf.toggle();
  }
}
</script>
