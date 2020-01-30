import { VuexModule, Module, Mutation, Action, getModule } from 'vuex-module-decorators'
import { RouteRecord, Route } from 'vue-router'
import store from '@/store'

export enum DeviceType {
  Mobile,
  Desktop,
}

export interface MenuItem {
  id: string;
  title: string;
  url?: string;
  icon?: string;
  children?: Array<MenuItem>;
}

export interface IAppState {
  device: DeviceType
  menu: {
    opened: boolean
    withoutAnimation: boolean
  },
  menuList: Array<MenuItem>;
  size: string,
  BreadcrumbList:Array<RouteRecord>
}

@Module({ dynamic: true, store, name: 'app' })
class App extends VuexModule implements IAppState {
  public menu = {
    opened: true,
    withoutAnimation: false
  }
  public size = 'medium'
  public device = DeviceType.Desktop
  public menuList = [
    {
      id: '1', title: "父菜单1", url: "", icon: 'iconfont icon-zhedie1', children: [
        { id: '2', title: "子菜单1-1", url: "/sys/dict", icon: 'iconfont icon-zhedie1', children: [] },
        { id: '3', title: "子菜单1-2", url: "/sys/role", icon: 'iconfont icon-zhedie1', children: [] },
        { id: '4', title: "子菜单1-3", url: "/sys/menu", icon: 'iconfont icon-zhedie1', children: [] }
      ]
    },
    {
      id: '5', title: "父菜单2", url: "", icon: 'iconfont icon-zhedie1', children: [
        { id: '6', title: "子菜单2-1", url: "", icon: 'iconfont icon-zhedie1', children: [] },
        {
          id: '7', title: "子菜单2-3", url: "", icon: 'iconfont icon-zhedie1', children: [
            { id: '12', title: "子菜单2-3-1", url: "", icon: 'iconfont icon-zhedie1', children: [] },
            { id: '13', title: "子菜单2-3-3", url: "", icon: 'iconfont icon-zhedie1', children: [] }
          ]
        }
      ]
    },
    {
      id: '8', title: "父菜单3", url: "", icon: 'iconfont icon-zhedie1', children: [
        { id: '9', title: "子菜单3-1", url: "", icon: 'iconfont icon-zhedie1', children: [] },
        { id: '10', title: "子菜单3-3", url: "", icon: 'iconfont icon-zhedie1', children: [] }
      ]
    },
    {
      id: '11', title: "菜单4", url: "/sys/dict", icon: 'iconfont icon-zhedie1', children: []
    }
  ];
  public BreadcrumbList=new Array<RouteRecord>();
  //Mutation 更新State
  @Mutation
  private GET_MENU() {

  }
  @Mutation
  private TOGGLE_SIDEBAR(withoutAnimation: boolean) {
    this.menu.opened = !this.menu.opened
    this.menu.withoutAnimation = withoutAnimation
  }
  @Mutation
  private CLOSE_SIDEBAR(withoutAnimation: boolean) {
    this.menu.opened = false
    this.menu.withoutAnimation = withoutAnimation
  }

  @Mutation
  private TOGGLE_DEVICE(device: DeviceType) {
    this.device = device
  }
  @Mutation
  private SET_SIZE(size: string) {
    this.size = size
  }
  @Mutation
  private SET_BREADCRUMB(list:Array<RouteRecord>){
    this.BreadcrumbList =list;
  }
  //action 处理请求
  @Action
  public getMenu() {
    this.GET_MENU()
  }
  @Action
  public ToggleSideBar(withoutAnimation: boolean) {
    this.TOGGLE_SIDEBAR(withoutAnimation)
  }

  @Action
  public CloseSideBar(withoutAnimation: boolean) {
    this.CLOSE_SIDEBAR(withoutAnimation)
  }

  @Action
  public ToggleDevice(device: DeviceType) {
    this.TOGGLE_DEVICE(device)
  }
  @Action
  public SetSize(size: string) {
    this.SET_SIZE(size)
  }
  @Action
  public setBreadcrumb(list:Array<RouteRecord>){
    this.SET_BREADCRUMB(list)
  }
}

export const AppModule = getModule(App)