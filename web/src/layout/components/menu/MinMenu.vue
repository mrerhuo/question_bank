<template>
  <div class="min_menu">
    <template v-for="item in menuData">
      <Dropdown v-if="item.children.length!=0" placement="right-start" :key="item.id">
        <a href="javascript:void(0)">
          <i :class="item.icon" class="min_menu_size" size="36"></i>
        </a>
        <DropdownMenu slot="list">
          <template v-for="secItem in item.children">
            <DropdownItem v-if="secItem.children.length==0" :key="secItem.id">
            <router-link :to="secItem.url" class="min_item_link">{{secItem.title}}</router-link>
            </DropdownItem>
            <template v-if="secItem.children.length!=0">
              <Dropdown placement="right-start" :key="secItem.id">
                <DropdownItem>
                  {{secItem.title}}
                  <Icon type="ios-arrow-forward"></Icon>
                </DropdownItem>
                <DropdownMenu slot="list">
                  <DropdownItem v-for="lastItem in secItem.children" :key="lastItem.id">
                    <router-link :to="lastItem.url" class="min_item_link">{{lastItem.title}}</router-link>
                  </DropdownItem>
                </DropdownMenu>
              </Dropdown>
            </template>
          </template>
        </DropdownMenu>
      </Dropdown>
      <Tooltip
        v-if="item.children.length==0"
        :content="item.title"
        placement="bottom"
        :key="item.id"
      >
        <router-link to="/foo">
          <i :class="item.icon" class="min_menu_size" size="36"></i>
        </router-link>
      </Tooltip>
    </template>
  </div>
</template>
<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";

@Component
export default class MinMenu extends Vue {
  @Prop({ type: Array, default: [] }) menuData!: any;
}
</script>
<style scoped lang="less">
.min_menu {
  margin: 0 10px 0 10px;
}
.min_item_link {
  height: 34px;
}
.min_menu_size {
  font-size: 36px;
  color: #ffffff;
}
.min_tsname {
  margin-left: 10px;
}
</style>