import { Component, Vue, Watch } from 'vue-property-decorator'
import { AppModule, DeviceType } from '@/store/modules/app'

const ScreenWidth = 992 //设置移动设备与桌面设备的宽度区分界限
// 设置window的resize事件监听屏幕大小变化，判断设备
@Component
export default class WindowResize extends Vue {

    get device() {
        return AppModule.device
    }

    get menu() {
        return {
          isOpen: !AppModule.menu.opened,
          mobile: AppModule.device === DeviceType.Mobile
        };
      }

    deviceType = false


    //计算变化
    mounted() {
        const isMobile = this.isMobile()
        if (isMobile) {
            AppModule.ToggleDevice(DeviceType.Mobile)
            AppModule.CloseSideBar(true)
        }
    }

    beforeMount() {
        window.addEventListener('resize', this.resizeHandler)
    }
    beforeDestroy() {
        window.removeEventListener('resize', this.resizeHandler)
    }
    //设置设备类型
    private resizeHandler() {
        if (!document.hidden) {
            const isMobile = this.isMobile()
            AppModule.ToggleDevice(isMobile ? DeviceType.Mobile : DeviceType.Desktop)
            if (isMobile) {
                AppModule.CloseSideBar(true)
            }
        }
    }
    //判断是否是移动端
    private isMobile() {
        const rect = document.body.getBoundingClientRect();
        Vue.prototype.$height=rect.height;
        return rect.width - 1 < ScreenWidth
    }
}