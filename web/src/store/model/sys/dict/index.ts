import {BaseQuery,BaseList} from '../../BaseModel'

class EditModel{
    groupId: number=0;
    groupName!:string;
    groupCode!:string;
    status!:string;
    sort!:string;
    remark!:string
}

interface QueryModel extends BaseQuery{
    groupName:string;
    groupCode:string;
    status:string;
}
interface DataList extends BaseList<EditModel>{

}
interface IGroupModels {
    editModel:EditModel,
    query:QueryModel,
    datas:DataList
}



export {IGroupModels,QueryModel,DataList,EditModel};