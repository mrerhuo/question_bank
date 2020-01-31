<template>
  <div>
     <Form ref="dataModel" :model="model" :rules="ruleValidate" :label-width="80">
        <Form-item label="原始密码" prop="oldPwd">
          <Input type="password" password v-model="model.oldPwd" placeholder="请输入原始密码"></Input>
        </Form-item>
        <Form-item label="新密码" prop="password">
          <Input type="password" password v-model="model.password" placeholder="请输入新密码"></Input>
        </Form-item>
        <Form-item label="确认密码" prop="confirmPwd">
          <Input type="password" password v-model="model.confirmPwd" placeholder="请输入确认密码"></Input>
        </Form-item>
        <FormItem>
            <Button type="primary">确定</Button>
            <Button style="margin-left: 8px">取消</Button>
        </FormItem>
      </Form>
  </div>
</template>
<script>
import { Component, Vue } from "vue-property-decorator";

@Component
export default class UserPwd extends Vue {
    model={
        oldPwd:'',
        password:'',
        confirmPwd:''
    };
    ruleValidate={
        oldPwd: [
          { required: true, message: "原始密码不能为空!", trigger: "blur" }
        ],
        password: [
          { required: true, validator: this.validatePass, trigger: "blur" },
          {
            type: "string",
            min: 8,
            max: 15,
            message: "密码太短，必须是8到15个字符之间！",
            trigger: "blur"
          }
        ],
        confirmPwd: [
          { required: true, validator: this.validatePassCheck, trigger: "blur" },
          {
            type: "string",
            min: 8,
            max: 15,
            message: "密码太短，必须是8到15个字符之间！",
            trigger: "blur"
          }
        ]
      };
      validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.model.confirmPwd !== "") {
          // 对第二个密码框单独验证
          this.$refs.model.validateField("confirmPwd");
        }
        callback();
      }
    };
    validatePassCheck = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.model.password) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
};
</script>
<style scoped lang="less">

</style>