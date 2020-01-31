<template>
  <div class="root_container" :style="{ 'height': pageHeight + 'px'}">
    <Row class="user_info">
      <Col span="6">
        <Card shadow>
          <p slot="title">个人中心</p>
          <div class="user_info_head">
            <img
              src="https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80"
              alt
            />
            <h1>XXX</h1>
          </div>
        </Card>
      </Col>
      <Col span="17" class="user_info_right">
        <Card shadow>
          <Tabs type="card">
            <TabPane label="信息维护">
              <user-info />
            </TabPane>
            <TabPane label="登录记录">
              <login-log />
            </TabPane>
            <TabPane label="密码修改">
              <modify-pwd />
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
.user_info_right {
  margin-left: 10px;
}
</style>