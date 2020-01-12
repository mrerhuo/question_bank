package online.jianchi.webapi.domain.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.hutool.core.util.IdUtil;

/*
 *作者：二先生
 *创建时间：2020年01月04日
 *说明：用户类
*/
@TableName(value = "t_user")//指定表名
public class SysUser {
    private String id;
    private String name;
    private Integer age;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId() {
        this.id = IdUtil.randomUUID();
    }
}