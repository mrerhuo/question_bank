<template>
  <div class="root_container" :style="{ 'height': pageHeight + 'px'}">
    <Row class="user_info">
      <Col :xl="6" :lg="9" :md="12" :sm="10" :xs="24"  class="user_info_left">
        <Card shadow>
          <p slot="title">个人中心</p>
          <div class="user_info_head">
            <img
              src="https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80"
              alt
            />
            <h1>XXX</h1>
          </div>
          <Divider />
          <CellGroup>
            <Cell title="账号" extra="account" />
            <Cell title="部门" extra="deptName" />
            <Cell title="行政区" extra="云南省昆明市五华区XXX路" />
            <Cell title="最后登录事件" extra="2020-12-12 53:54:32" />
            <Cell title="姓名" extra="某先生" />
            <Cell title="手机号" extra="13518745952" />
            <Cell title="邮件" extra="silence_ailong@qq.com" />
          </CellGroup>
        </Card>
      </Col>
      <Col :xl="18" :lg="15" :md="12" :sm="14" :xs="24" class="user_info_right" >
        <Card shadow >
          <Tabs type="card">
            <TabPane label="信息维护">
              <user-info />
            </TabPane>
            <TabPane label="密码修改">
              <modify-pwd />
            </TabPane>
            <TabPane label="登录记录">
              <login-log />
            </TabPane>
          </Tabs>
        </Card>
      </Col>
    </Row>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import LoginLog from "./loginlog.vue";
import ModifyPwd from "./modifyPwd.vue";
import UserInfo from "./userinfo.vue";
@Component({
  components: {
    LoginLog,
    ModifyPwd,
    UserInfo
  }
})
export default class UserIndex extends Vue {
  pageHeight = Vue.prototype.$height - 133; //空白页为：133查询条件一行：237 查询条件2行269
}
</script>

<style scoped lang="less">
.user_info {
  margin-top: 30px;
  margin-left: 10px;
  margin-right: 10px;
}
.user_info_head {
  text-align: center;
}
.user_info_left {
  padding: 10px 10px 10px 10px;
}
.user_info_right {
  padding: 10px 10px 10px 10px;
}
</style>