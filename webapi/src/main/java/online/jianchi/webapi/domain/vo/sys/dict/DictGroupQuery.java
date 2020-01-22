package online.jianchi.webapi.domain.vo.sys.dict;

/***
 * 查询实体
 * 
 * @author 二先生 @date：2020年01月22日
 */
public class DictGroupQuery {
    /*
     * 分组名称
     */
    private String groupName;
    /*
     * 分组代码
     */
    private String groupCode;
    /*
     * 状态
     */
    private String status;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}