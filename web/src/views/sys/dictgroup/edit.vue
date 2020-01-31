<template>
  <Modal :value="value" :title="modalTitle" @on-visible-change="visibleChange">
    <Form ref="saveForm" :model="model" :rules="modelValidate" :label-width="80">
      <FormItem label="编号" prop="groupId">
        <Input v-model="model.groupId" placeholder="Enter your name"></Input>
      </FormItem>
      <FormItem label="代码" prop="groupCode">
        <Input v-model="model.groupCode" placeholder="Enter your name"></Input>
      </FormItem>
      <FormItem label="名称" prop="groupName">
        <Input v-model="model.groupName" placeholder="Enter your name"></Input>
      </FormItem>
      <FormItem label="状态" prop="status">
        <Input v-model="model.status" placeholder="Enter your name"></Input>
      </FormItem>
      <FormItem label="排序" prop="sort">
        <Input v-model="model.sort" placeholder="Enter your name"></Input>
      </FormItem>
      <FormItem label="备注" prop="remark">
        <Input v-model="model.remark" placeholder="Enter your name"></Input>
      </FormItem>
    </Form>
    <div slot="footer">
      <Button @click="cancel">取消</Button>
      <Button @click="save" type="primary">保存</Button>
    </div>
  </Modal>
</template>
<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
import { DictGroup } from "@/store/modules/sys/DictGroup";
import { EditModel } from "@/store/model/sys/dict";
@Component
export default class EditView extends Vue {
  @Prop({ type: Boolean, default: false }) value!: boolean;
  @Prop({ type: Number, default: 0 }) keyId!: number;
  model: EditModel = new EditModel();
  get modalTitle() {
    return this.keyId === 0 ? "新增信息" : "编辑信息";
  }
  visibleChange(value: boolean) {
    if (!value) {
      this.cancel();
    } else {
      this.model.groupId = this.keyId;
      this.model=DictGroup.editModel;
    }
  }
  save() {
    (this.$refs.saveForm as any).validate(async (valid: boolean) => {
      if (valid) {
        //判断为0新增，否则编辑
        if (this.keyId === 0) {
        } else {
        }
        (this.$refs.saveForm as any).resetFields();
        this.$emit("save-success");
        this.$emit("input", false);
      }
    });
  }
  cancel() {
    (this.$refs.saveForm as any).resetFields();
    this.$emit("input", false);
  }
  modelValidate = {
    groupCode: [
      { required: true, message: "请输入分组代码", trigger: "blur" }
    ],
    groupName: [
      {
        required: true,
        message: "请输入分组名称",
        trigger: "blur"
      }
    ]
  };
}
</script>

<style scoped lang="less">
</style>