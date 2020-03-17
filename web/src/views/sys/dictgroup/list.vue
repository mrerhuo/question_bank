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
        <Input
          class="search_item"
          v-model="query.status"
          placeholder="状态"
          style="width: 150px"
        />
        <Button class="search_item" @click="getPage()"
          ><i class="iconfont icon-xiaodaiapp03"></i> 查询</Button
        >
        <Button class="search_item" type="primary" @click="addInfo()"
          ><i class="iconfont icon-xinzeng1"></i> 新增</Button
        >
      </Col>
    </Row>
    <Row>
      <Col span="24">
        <Table
          :height="pageHeight"
          :loading="datas.loading"
          border
          ref="selection"
          :columns="columns"
          :data="datas.rows"
        >
          <template slot-scope="{ row, index }" slot="action">
            <Tooltip content="详细信息" placement="top">
              <Button
                size="small"
                style="margin-right: 5px"
                @click="showInfo(row.groupId)"
              >
                <i class="iconfont icon-xiangxiguihua table_btn_info"></i>
              </Button>
            </Tooltip>
            <Tooltip content="编辑" placement="top">
              <Button
                size="small"
                style="margin-right: 5px"
                @click="editInfo(row.groupId)"
              >
                <i class="iconfont icon-editgroups table_btn_edit"></i>
              </Button>
            </Tooltip>
            <Tooltip content="删除" placement="top">
              <Poptip
                confirm
                title="是否确认删除？"
                @on-ok="delteInfo(row.groupId)"
                placement="left"
              >
                <Button size="small">
                  <i class="iconfont icon-shanchu table_btn_delete"></i>
                </Button>
              </Poptip>
            </Tooltip>
          </template>
        </Table>
      </Col>
    </Row>
    <div class="page_container">
      <Page :total="datas.total" show-elevator show-sizer show-total />
    </div>
    <edit-view v-model="editViewShow" :key-id="keyId" @save-success="getPage" />
    <detail-view
      v-model="detailViewShow"
      :key-id="keyId"
      @save-success="getPage"
    />
  </div>
</template>
<script lang="ts">
import { Component, Vue, Inject, Prop, Watch } from "vue-property-decorator";
import { AppModule } from "@/store/modules/app";
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
    await DictGroup.deleteModel(id);
  }
  async getPage() {
    await DictGroup.getPges(this.query);
  }

  value1 = "";
  get pageHeight() {
    return AppModule.height - 237;
  }
  columns = [
    {
      title: "序号",
      type: "index",
      width: 60,
      align: "center"
    },
    {
      title: "分组名称",
      key: "groupName"
    },
    {
      title: "分组代码",
      key: "groupCode"
    },
    {
      title: "状态",
      key: "status"
    },
    {
      title: "排序",
      key: "sort"
    },
    {
      title: "备注",
      key: "remark"
    },
    {
      title: "操作",
      slot: "action",
      width: 220,
      align: "center"
    }
  ];
}
</script>
<style scoped lang="less"></style>
