import { VuexModule, Module, Mutation, Action, getModule } from 'vuex-module-decorators'
import store from '@/store'

export enum DeviceType {
    Mobile,
    Desktop,
}

export interface IAppState {
    device: DeviceType
    menu: {
        opened: boolean
        withoutAnimation: boolean
    }
    size: string
}
@Module({ dynamic: true, store, name: 'app' })
class App extends VuexModule implements IAppState {
    public menu = {
        opened: true,
        withoutAnimation: false
    }
    public size = 'medium'
    public device = DeviceType.Desktop

    @Mutation
    private TOGGLE_SIDEBAR(withoutAnimation: boolean) {
       
        this.menu.opened = !this.menu.opened
        console.log(this.menu.opened);
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
  
}

export const AppModule = getModule(App)