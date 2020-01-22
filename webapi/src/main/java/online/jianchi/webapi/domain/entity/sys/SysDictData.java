package online.jianchi.webapi.domain.entity.sys;

import cn.hutool.core.util.IdUtil;
import online.jianchi.webapi.base.BaseEntity;

/*
 * 作者：二先生
 * 日期：2020年01月08日
 * 说明：字典数据类
 */
public class SysDictData extends BaseEntity {
    /*
     * 数据字典编号
     */
    private String dictId;
    /*
     * 分组代码
     */
    private String groupCode;
    /*
     * 字典文本
     */
    private String dictLabel;
    /*
     * 字典键值
     */
    private String dictValue;
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

    public String getDictId() {
        return dictId;
    }

    public void setDictId() {
        this.dictId = IdUtil.randomUUID();
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
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