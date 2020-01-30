<template>
  <Footer class="layout_footer">2019-{{endYear}} © XXXXX局 技术支持：xxxxxxx有限公司</Footer>
</template>
<script lang="ts">
import { Component, Vue, Watch } from "vue-property-decorator";

@Component
export default class FooterLayout extends Vue {
    
    get endYear(){
        let date = new Date();
        return date.getFullYear().toString();
    }
}
</script>
<style scoped lang="less">
.layout_footer {
  text-align: center;
}
</style>