
//查询
interface BaseQuery {
    pageNumber: number;
    pageSize: number;
}
//列表
interface BaseList<T> {
    total: number,
    rows: Array<T>,
    loading: boolean
}
export {BaseQuery,BaseList}