package online.jianchi.webapi.domain.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import online.jianchi.webapi.base.BaseEntity;

/*
 * 作者：二先生
 * 日期：2020年01月08日
 * 说明：字典分组数据
 */
@TableName("sys_dict_group")
public class SysDictGroup extends BaseEntity {
    /*
     * 分组编号
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long groupId;
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
    /*
     * 排序
     */
    private String sort;
    /*
     * 备注
     */
    private String remark;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}