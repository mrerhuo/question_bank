<template>
    <div class="layout-breadcrumb">
        <Breadcrumb>
            <Breadcrumb-item :to="item.name=='home'?item.path:''" v-for="item in list" :key="item.path">
                <i :class="item.meta.icon">{{item.meta.title}}</i> 
            </Breadcrumb-item>
        </Breadcrumb>
    </div>
</template>

<script lang="ts">
import { Component,Vue } from "vue-property-decorator";
import { AppModule } from "@/store/modules/app";
@Component
export default class CusBreadcrumb extends Vue {
  get list(){
    return AppModule.BreadcrumbList;
  }
}
</script>
<style scoped lang="less">
.layout-breadcrumb{
  position: absolute;
  background-color: #eeeeee;
  width: 100%;
}

</style>
