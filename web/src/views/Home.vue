<template>
  <div class="root_container home_bg">
  <el-button type="text" @click="dialog = true">打开嵌套 Form 的 Drawer</el-button>
      <el-drawer
      title="我嵌套了 Form !"
      :visible.sync="dialog"
      direction="ltr"
      custom-class="demo-drawer"
      ref="drawer"
    >
      <span>sssss</span>
    </el-drawer>
  </div>
  
</template>
<script>
export default {
  components: {},
  props: {},
  data() {
    return {
      dialog:false
    };
  },
  computed: {},
  mounted() {},
  methods: {},
  created() {},
  watch: {}
};
</script>
<style scoped lang="scss">
.home_bg{
  background-color: cornflowerblue;
}
</style>