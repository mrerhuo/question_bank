package online.jianchi.webapi.base;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * 作者：二先生
 * 日期：2020年01月08日
 * 说明：基础实体类
 */
public class BaseEntity {
    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime() {
        this.createTime = LocalDateTime.now();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime() {
        this.updateTime = LocalDateTime.now();
    }
}