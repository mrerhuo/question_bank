<template>
  <Menu theme="dark" width="auto">
    <template v-for="item in menuData">
      <Submenu v-if="item.children.length!=0" :name="item.id" :key="item.id">
        <template slot="title">
          <i :class="item.icon" />
          {{item.title}}
        </template>
        <template v-for="secItem in item.children">
          <MenuItem
            v-if="secItem.children.length==0"
            :name="secItem.id"
            :to="secItem.url"
            :key="secItem.id"
          >
            <i :class="secItem.icon" />
            {{secItem.title}}
          </MenuItem>
          <Submenu v-if="secItem.children.length!=0" :name="secItem.id" :key="secItem.id">
            <template slot="title">
              <i :class="secItem.icon" />
              {{secItem.title}}
            </template>
            <MenuItem
              v-for="lastItem in secItem.children"
              :name="lastItem.id"
              :to="lastItem.url"
              :key="lastItem.id"
            >
              <i :class="lastItem.icon" />
              {{lastItem.title}}
            </MenuItem>
          </Submenu>
        </template>
      </Submenu>
      <MenuItem v-if="item.children.length==0" :to="item.url" :key="item.id" :name="item.id">
        <i :class="item.icon" />
        {{item.title}}
      </MenuItem>
    </template>
  </Menu>
</template>
<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";

@Component
export default class SideMenu extends Vue {
  @Prop({ type: Array, default: [] }) menuData: any;
}
</script>
<style scoped lang="less">
</style>