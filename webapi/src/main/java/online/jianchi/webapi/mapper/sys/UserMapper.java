package online.jianchi.webapi.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;

import online.jianchi.webapi.entity.SysUserEntity;

/*
 *作者：二先生
 *创建时间：2020年01月04日
 *说明：UserEntity映射
*/
public interface UserMapper extends BaseMapper<SysUserEntity> {
    
    SysUserEntity selectByStringId(@Param("id") String string);
}