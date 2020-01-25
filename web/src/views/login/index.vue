<template>
  <div class="login-container">
    <el-form
      :model="dataModel"
      status-icon
      :rules="formRules"
      label-position="top"
      ref="dataModel"
      label-width="100px"
      class="login-form"
    >
      <h3 class="title">坚持后台管理系统</h3>
      <el-form-item prop="userName">
        <el-input v-model="dataModel.userName" autocomplete="off" :maxlength="30" placeholder="用户名">
          <i slot="prefix" class="iconfont icon-user"></i>
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          type="password"
          v-model="dataModel.password"
          autocomplete="off"
          :maxlength="30"
          placeholder="密    码"
          show-password
        >
          <i slot="prefix" class="iconfont icon-Mask"></i>
        </el-input>
      </el-form-item>
      <el-form-item prop="code">
        <el-input style="width:50%;" v-model="dataModel.code" :maxlength="6" placeholder="验证码">
          <i slot="prefix" class="iconfont icon-yanzhengma"></i>
        </el-input>
      </el-form-item>
      <el-form-item prop="isRember">
        <el-checkbox v-model="dataModel.isRember">记住我？</el-checkbox>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width:100%;" :loading="loading" @click="login()">
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width:100%;" @click="otherLogin()">
          <span>第三方登录</span>
        </el-button>
      </el-form-item>
    </el-form>
    <other-login v-model="showOterLogtin" />
  </div>
</template>
<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import otherLogin from "./other.vue";

@Component({
  components: { otherLogin }
})
export default class Login extends Vue {
  dataModel = {
    userName: "",
    password: "",
    code: "",
    isRember: false
  };
  showOterLogtin: boolean = false;
  loading: boolean = false;
  async login() {
    this.loading = true;
    (this.$refs.dataModel as any).validate(async (valid: boolean) => {
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
  background-color: #b0bec5;
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