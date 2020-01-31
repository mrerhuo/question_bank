<template>
  <div>
    <Form ref="model" :model="model" :rules="ruleValidate" :label-width="100">
        <Form-item style="display:none;" prop="userId">
          <Input v-model="model.userId"></Input>
        </Form-item>
        <Row>
          <Col span="12">
            <Form-item label="账号" prop="account">{{model.account}}</Form-item>
          </Col>
          <Col span="12">
            <Form-item label="部门" prop="deptName">{{model.deptName}}</Form-item>
          </Col>
        </Row>
        <Row>
          <Col span="12">
            <Form-item label="行政区" prop="areaCode">{{model.areaName}}</Form-item>
          </Col>
          <Col span="12">
            <Form-item label="最后登录时间" prop="areaCode">{{model.lastLoginTime}}</Form-item>
          </Col>
        </Row>
        <Form-item label="姓名" prop="userName">
          <Input v-model="model.userName" placeholder="请输入姓名"></Input>
        </Form-item>
        <Form-item label="手机号码" prop="phone">
          <Input v-model="model.phone" placeholder="请输入手机号码"></Input>
        </Form-item>
        <Form-item label="邮件" prop="email">
          <Input v-model="model.email" placeholder="请输入邮件"></Input>
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
export default class UserInfo extends Vue {
  model={
    };
    ruleValidate={}
};
</script>

<style scoped lang="less">

</style>