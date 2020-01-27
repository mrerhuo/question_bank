<template>
  <div class="login-container">
    <Form
      ref="logForm"
      :model="dataModel"
      :rules="formRules"
      label-position="top"
      :label-width="0"
      class="login-form"
    >
      <h3 class="title">坚持后台管理系统</h3>
      <FormItem prop="userName">
        <Input v-model="dataModel.userName" :maxlength="30" placeholder="用户名">
          <i slot="prefix" class="iconfont icon-user"></i>
        </Input>
      </FormItem>
      <FormItem prop="password">
        <Input
          v-model="dataModel.password"
          type="password"
          :maxlength="30"
          password
          placeholder="密    码"
        >
          <i slot="prefix" class="iconfont icon-Mask"></i>
        </Input>
      </FormItem>
      <FormItem prop="code">
        <Input style="width:50%;" v-model="dataModel.code" :maxlength="6" placeholder="验证码">
          <i slot="prefix" class="iconfont icon-yanzhengma"></i>
        </Input>
      </FormItem>
      <FormItem prop="isRember">
        <Checkbox v-model="dataModel.isRember">记住我？</Checkbox>
      </FormItem>
      <FormItem>
        <Button type="primary" long @click="login()">登录</Button>
      </FormItem>
      <FormItem>
        <Button type="primary" long @click="otherLogin()">第三方登录</Button>
      </FormItem>
    </Form>
    <other-login v-model="showOterLogtin" />
  </div>
</template>
<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import OtherLogin from "./other.vue";

@Component({
  components: { OtherLogin }
})
export default class Login extends Vue {
  dataModel = {
    userName: "",
    password: "",
    code: "",
    isRember: false
  };

  loading: boolean = false;
  async login() {
    this.loading = true;
    (this.$refs.logForm as any).validate(async (valid: boolean) => {
      if (valid) {
        await setTimeout(() => {
          this.loading = false;
          this.$router.push("/home");
        }, 0.5 * 1000);
      } else {
        this.loading = false;
      }
    });
  }

  showOterLogtin: boolean = false;
  otherLogin() {
    this.showOterLogtin = true;
  }
  formRules = {
    userName: [{ required: true, message: "请输入用户名", trigger: "blur" }],
    password: [{ required: true, message: "请输入密码", trigger: "blur" }],
    code: [{ required: true, message: "请输入验证码", trigger: "blur" }]
  };
}
</script>
<style scoped lang="less">
.login-container {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #0593da;
}
.login-form {
  border-radius: 6px;
  background: #ffffff;
  width: 400px;
  padding: 25px 25px 5px 25px;
}
.title {
  margin: 0px auto 30px auto;
  text-align: center;
  color: #707070;
}
</style>