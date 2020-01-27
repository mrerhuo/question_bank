declare global {
    interface RouterMeta {
        title: string;
        icon?: string;
    }
    interface Router {
        path: string;
        name: string;
        permission?: string;
        meta?: RouterMeta;
        component: any;
        children?: Array<Router>;
    }
    interface System {
        import(request: string): Promise<any>
    }
    var System: System
}
import Login from '@/views/login/index.vue'
import Layout from '@/layout/index.vue';
import Home from '@/views/home.vue'

import DictGroupList from '@/views/sys/dictgroup/list.vue';

export const loginRouter: Router = {
    path: '',
    name: 'login',
    meta: {
        title: '登录'
    },
    component: Login
};

export const homeRouter: Router = {
    path: '',
    name: 'layout',
    meta: {
        title: '布局'
    },
    component: Layout,
    children: [{
        path: 'home',
        name: 'home',
        meta: { title: '主页' },
        component: Home
    }]
};

// export const sysRouter: Router = {
//     path: '/sys',
//     name: 'sys',
//     meta: {
//         title: '布局'
//     },
//     component: Layout,
//     children: [{
//         path: 'dict',
//         name: 'dict',
//         meta: { title: '字典管理' },
//         component: DictGroupList
//     }]
// };sysRouter

export const routers = [
    loginRouter,
    homeRouter
];