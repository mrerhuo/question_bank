<template>
  <div class="root_container">
    <Row class="row_container">
      <Col span="24">
        <Input
          class="search_item"
          v-model="query.groupCode"
          placeholder="分组代码"
          style="width: 150px"
        />
        <Input
          class="search_item"
          v-model="query.groupName"
          placeholder="分组名称"
          style="width: 150px"
        />
        <Input class="search_item" v-model="query.status" placeholder="状态" style="width: 150px" />
        <Button class="search_item" @click="getPage()">查询</Button>
        <Button class="search_item" type="primary" @click="addInfo()">新增</Button>
      </Col>
    </Row>
    <Row>
      <Col span="24">
        <Table :height="pageHeight" :loading="datas.loading" border ref="selection" :columns="columns" :data="datas.rows">
          <template slot-scope="{ row, index }" slot="action">
            <Button
              type="primary"
              size="small"
              style="margin-right: 5px"
              @click="showInfo(row.groupId)"
            >详细信息</Button>
            <Button
              type="primary"
              size="small"
              style="margin-right: 5px"
              @click="editInfo(row.groupId)"
            >编辑</Button>
            <Poptip confirm title="是否确认删除？" @on-ok="delteInfo(row.groupId)" placement="left">
              <Button type="error" size="small">删除</Button>
            </Poptip>
          </template>
        </Table>
      </Col>
    </Row>
    <div class="page_container">
      <Page :total="datas.total" show-elevator show-sizer show-total />
    </div>
    <edit-view v-model="editViewShow" :key-id="keyId" @save-success="getPage" />
    <detail-view v-model="detailViewShow" :key-id="keyId" @save-success="getPage" />
  </div>
</template>
<script lang="ts">
import { Component, Vue, Inject, Prop, Watch } from "vue-property-decorator";
import EditView from "./edit.vue";
import DetailView from "./detail.vue";
import { DictGroup } from "@/store/modules/sys/DictGroup";

@Component({ components: { EditView, DetailView } })
export default class DictGroupPage extends Vue {
  get datas() {
    return DictGroup.datas;
  }
  get query() {
    return DictGroup.query;
  }
  async created() {
    await this.getPage();
  }
  editViewShow: boolean = false;
  detailViewShow: boolean = false;
  keyId: number = 0;
  //详细信息
  async showInfo(id: number) {
    this.keyId = id;
    await DictGroup.getModel(id);
    this.detailViewShow = true;
  }
  //新增
  addInfo() {
    this.editViewShow = true;
  }
  //编辑
  async editInfo(id: number) {
    this.keyId = id;
    await DictGroup.getModel(id);
    this.editViewShow = true;
  }
  //删除
  async delteInfo(id: number) {
    console.log(id);
     await DictGroup.deleteModel(id);
  }
  async getPage() {
    await DictGroup.getPges(this.query);
  }

  value1 = "";
  pageHeight = Vue.prototype.$height - 263; //查询条件一行：263 查询条件2行295
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
    },
    {
      title: "Action",
      slot: "action",
      width: 220,
      align: "center"
    }
  ];
}
</script>
<style scoped lang="less">
</style>