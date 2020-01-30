<template>
  <Modal :value="value" title="详细信息" :footer-hide="true" @on-visible-change="visibleChange">
    <table class="table_info">
      <tr>
        <th style="width:35%">编号</th>
        <td style="width:65%">{{model.groupId}}</td>
      </tr>
      <tr>
        <th>代码</th>
        <td>{{model.groupCode}}</td>
      </tr>
      <tr>
        <th>名称</th>
        <td>{{model.groupName}}</td>
      </tr>
      <tr>
        <th>状态</th>
        <td>{{model.status}}</td>
      </tr>
      <tr>
        <th>排序</th>
        <td>{{model.sort}}</td>
      </tr>
      <tr>
        <th>备注</th>
        <td>{{model.remark}}</td>
      </tr>
    </table>
  </Modal>
</template>
<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
import { DictGroup } from "@/store/modules/sys/DictGroup";
import { EditModel } from "@/store/model/sys/dict";
@Component
export default class DetailView extends Vue {
  @Prop({ type: Boolean, default: false }) value!: boolean;
  @Prop({ type: Number, default: 0 }) keyId!: number;
  model: EditModel = new EditModel();
  handleClose() {
    if (!this.value) {
      this.$emit("input", false);
    }
  }
  visibleChange(value: boolean) {
    if (!value) {
      this.$emit("input", value);
    } else {
      this.model.groupId = this.keyId;
      this.model = DictGroup.editModel;
    }
  }
}
</script>

<style scoped lang="less">
</style>