package online.jianchi.webapi.domain.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;

import online.jianchi.webapi.domain.entity.sys.SysUser;




/*
 *作者：二先生
 *创建时间：2020年01月04日
 *说明：UserEntity映射
*/
public interface UserMapper extends BaseMapper<SysUser> {
    
    SysUser selectByStringId(@Param("id") String string);
}