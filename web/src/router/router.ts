declare global {
  interface RouterMeta {
    title: string;
    icon?: string;
    isNav?: boolean;
  }
  interface Router {
    path: string;
    name?: string;
    alias?: string;
    permission?: string;
    meta?: RouterMeta;
    component: any;
    children?: Array<Router>;
  }
  interface System {
    import(request: string): Promise<any>;
  }
  var System: System;
}
import Redirect from "@/layout/redirect/index.vue";
import Login from "@/views/login/index.vue";
import Layout from "@/layout/index.vue";
import Home from "@/views/Home.vue";

import MenuList from "@/views/sys/menu/list.vue";
import RoleList from "@/views/sys/role/list.vue";
import DictGroupList from "@/views/sys/dictgroup/list.vue";
import UserInfo from "@/components/userinfo/index.vue";

export const loginRouter: Router = {
  path: "",
  name: "login",
  meta: {
    title: "登录"
  },
  component: Login
};
export const redirectRouter: Router = {
  path: "/redirect/:path*",
  component: Redirect
  // children: [{
  //     path: '/redirect/:path*',
  //     component: Redirect
  // }]
};
export const homeRouter: Router = {
  path: "",
  name: "layout",
  meta: {
    title: "layout",
    isNav: false
  },
  component: Layout,
  children: [
    {
      path: "home",
      name: "home",
      meta: { isNav: true, title: "主页", icon: "iconfont icon-shouye" },
      component: Home
    }
  ]
};

export const sysRouter: Router = {
  path: "/sys",
  name: "sys",
  meta: {
    title: "系统管理",
    isNav: false,
    icon: "iconfont icon-shezhi"
  },
  component: Layout,
  children: [
    {
      path: "menu",
      name: "menu",

      meta: { isNav: true, title: "菜单管理", icon: "iconfont icon-zhedie1" },
      component: MenuList
    },
    {
      path: "role",
      name: "role",
      meta: { isNav: true, title: "角色管理", icon: "iconfont icon-zhedie1" },
      component: RoleList
    },
    {
      path: "dict",
      name: "dict",
      meta: { isNav: true, title: "字典管理", icon: "iconfont icon-zhedie1" },
      component: DictGroupList
    },
    {
      path: "userinfo",
      name: "userinfo",
      meta: { isNav: true, title: "个人中心", icon: "iconfont icon-user" },
      component: UserInfo
    }
  ]
};
sysRouter;

export const routers = [redirectRouter, loginRouter, homeRouter, sysRouter];
