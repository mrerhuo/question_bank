import { VuexModule, Module, Mutation, Action, getModule } from 'vuex-module-decorators'
import { IGroupModels, EditModel, QueryModel, DataList } from '../../model/sys/dict'
import store from '@/store'


@Module({ dynamic: true, store, name: 'DictGroup' })
class DictGroupState extends VuexModule implements IGroupModels {
    query = {
        pageNumber: 1,
        pageSize: 20,
        groupName: '',
        groupCode: '',
        status: '',
    }
    editModel = {
        groupId: 0,
        groupName: '',
        groupCode: '',
        status: '',
        sort: '',
        remark: '',
    }
    datas = {
        total: 200,
        rows: new Array<EditModel>(),
        loading: false
    }
    @Mutation
    private setModel(model: EditModel) {
      this.editModel = model
    }

    @Action
    public async getPges(query: QueryModel) {
        this.datas.loading = true;
        setTimeout(() => {
            this.datas.total = 31;
            this.datas.rows = [{ groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }
                , { groupId: 1, groupName: '测试', groupCode: 'code1', status: '1', sort: '01', remark: '' }];
            this.datas.loading = false;
        }, 1000);
    }
    @Action
    public async getModel(id: number) {
        let model = {
            groupId: 666,
            groupName: '777',
            groupCode: '888',
            status: '999',
            sort: '111',
            remark: '',
        }
        this.setModel(model);
    }
    public async deleteModel(id: number){

    }
}
export const DictGroup = getModule(DictGroupState)