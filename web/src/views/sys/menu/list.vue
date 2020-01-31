<template>
  <div class="root_container">
    <Row class="row_container">
      <Col span="24">
        <Input class="search_item" v-model="query.groupCode" placeholder="分组代码" style="width: 150px" />
        <Input class="search_item" v-model="query.groupName" placeholder="分组名称" style="width: 150px" />
        <Input class="search_item" v-model="query.status" placeholder="状态" style="width: 150px" />
        <Input class="search_item" v-model="query.groupCode" placeholder="分组代码" style="width: 150px" />
        <Input class="search_item" v-model="query.groupName" placeholder="分组名称" style="width: 150px" />
        <Input class="search_item" v-model="query.status" placeholder="状态" style="width: 150px" />
        <Input class="search_item" v-model="query.groupCode" placeholder="分组代码" style="width: 150px" />
        <Input class="search_item" v-model="query.groupName" placeholder="分组名称" style="width: 150px" />
        <Input class="search_item" v-model="query.status" placeholder="状态" style="width: 150px" />
        <Button class="search_item">查询</Button>
        <Button class="search_item" type="primary">新增</Button>
      </Col>
    </Row>
    <Row>
      <Col span="24">
        <Table :height="pageHeight" border ref="selection" :columns="columns" :data="datas.rows"></Table>
      </Col>
    </Row>
    <div class="page_container">
      <Page :total="datas.total" show-elevator show-sizer show-total />
    </div>
  </div>
</template>
<script lang="ts">
import { Component, Vue, Inject, Prop, Watch } from "vue-property-decorator";
import {
  IGroupModels,
  EditModel,
  QueryModel,
  DataList
} from "@/store/model/sys/dict";
import { DictGroup } from "@/store/modules/sys/DictGroup";
@Component
export default class DictGroupPage extends Vue {
  get datas() {
    return DictGroup.datas;
  }
  get query() {
    return DictGroup.query;
  }
  async created() {
    await DictGroup.getPges(this.query);
  }
  value1 = "";
  pageHeight = Vue.prototype.$height - 269;//空白页为：133查询条件一行：237 查询条件2行269
  columns = [
    {
      type: "index",
      width: 60,
      align: "center"
    },
    {
      title: "groupId",
      key: "groupId"
    },
    {
      title: "groupName",
      key: "groupName"
    },
    {
      title: "groupCode",
      key: "groupCode"
    },
    {
      title: "status",
      key: "status"
    },
    {
      title: "sort",
      key: "sort"
    },
    {
      title: "remark",
      key: "remark"
    }
  ];
}
</script>
<style scoped lang="less">
</style>