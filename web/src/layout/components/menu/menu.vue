<template>
  <el-menu

    class="menu"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
    :collapse-transition="false"
    :unique-opened="false"
    :collapse="value"
  >
    <el-submenu index="1">
      <template slot="title">
        <i class="el-icon-location"></i>
        <span slot="title">导航一</span>
      </template>
      <el-menu-item-group>
        <span slot="title">分组一</span>
        <el-menu-item index="1-1">选项1</el-menu-item>
        <el-menu-item index="1-2">选项2</el-menu-item>
      </el-menu-item-group>
      <el-menu-item-group title="分组2">
        <el-menu-item index="1-3">选项3</el-menu-item>
      </el-menu-item-group>
      <el-submenu index="1-4">
        <span slot="title">选项4</span>
        <el-menu-item index="1-4-1">选项1</el-menu-item>
      </el-submenu>
    </el-submenu>
    <el-menu-item index="2">
      <i class="el-icon-menu"></i>
      <span slot="title">导航二</span>
    </el-menu-item>
    <el-menu-item index="3" disabled>
      <i class="el-icon-document"></i>
      <span slot="title">导航三</span>
    </el-menu-item>
    <el-menu-item index="4">
      <i class="el-icon-setting"></i>
      <span slot="title">导航四</span>
    </el-menu-item>
  </el-menu>
</template>
<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";

@Component
export default class Menu extends Vue {
  @Prop({ type: Boolean, default: false }) value: boolean;

  menuList = [
    {
      path: "/permission",
      meta: {
        title: "权限测试页",
        icon: "lock",
        roles: ["admin", "editor"]
      },
      children: [
        {
          path: "page",
          meta: {
            title: "页面权限",
            roles: ["admin"] // or you can only set roles in sub nav
          }
        },
        {
          path: "directive",
          meta: {
            title: "指令权限"
          }
        },
        {
          path: "role",
          meta: {
            title: "角色权限",
            roles: ["admin"]
          }
        }
      ]
    },
    {
      path: "/icon",
      children: [
        {
          path: "index",
          meta: {
            title: "图标",
            icon: "icon",
            noCache: true
          }
        }
      ]
    },
    {
      path: "/nested",
      redirect: "/nested/menu1",
      name: "Nested",
      meta: {
        title: "嵌套路由",
        icon: "nested"
      },
      children: [
        {
          path: "menu1",
          meta: { title: "菜单1" },
          children: [
            {
              path: "menu1-1",
              meta: { title: "菜单1-1" }
            },
            {
              path: "menu1-2",
              name: "Menu1-2",
              meta: { title: "菜单1-2" },
              children: [
                {
                  path: "menu1-2-1",
                  meta: { title: "菜单1-2-1" }
                },
                {
                  path: "menu1-2-2",
                  meta: { title: "菜单1-2-2" }
                }
              ]
            },
            {
              path: "menu1-3",
              meta: { title: "菜单1-3" }
            }
          ]
        },
        {
          path: "menu2",
          meta: { title: "菜单2" }
        }
      ]
    },
    {
      path: "/error",
      redirect: "noredirect",
      meta: {
        title: "错误页面",
        icon: "404"
      },
      children: [
        {
          path: "401",
          meta: {
            title: "无权页面401",
            noCache: true
          }
        },
        {
          path: "404",
          meta: {
            title: "错误页面404",
            noCache: true
          }
        }
      ]
    },
    {
      path: "/theme",
      children: [
        {
          path: "index",
          meta: {
            title: "换肤",
            icon: "theme"
          }
        }
      ]
    },
    {
      path: "external-link",
      children: [
        {
          path: "https://github.com/Armour/vue-typescript-admin-template",
          meta: {
            title: "外部链接",
            icon: "link"
          }
        }
      ]
    },
    {
      path: "*",
      redirect: "/404",
      meta: { hidden: true }
    }
  ];
}
</script>
<style scoped lang="scss">
.menu:not(.el-menu--collapse) {
    width: 180px;
    min-height: 400px;
  }
</style>