package online.jianchi.webapi.controller;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.convert.Convert;
import io.swagger.annotations.Api;
import online.jianchi.webapi.domain.entity.sys.SysUser;
import online.jianchi.webapi.domain.mapper.sys.UserMapper;
import online.jianchi.webapi.domain.vo.sys.UserModel;


/*
 *作者：二先生
 *创建时间：2020年01月04日
 *说明：登录控制器
*/
@Api(tags = "account", description = "登录控制器")
@RestController
@RequestMapping("/account")
public class AccountController {
    
    @Autowired
    private UserMapper userMapper;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String test() {
        // List<SysUserEntity> userList = userMapper.selectList(null);
        
        Wrapper<SysUser> wrapper = new QueryWrapper<SysUser>().lambda().like(SysUser::getName, "n");
        List<SysUser> list=userMapper.selectList(wrapper);
        if(list!=null){
            for (SysUser userModel : list) {
                System.out.println(userModel.getName());;
            }
        }
        SysUser entity=userMapper.selectByStringId("3");
        System.out.println(entity.getName());
        // entity.setName("name");
        // userMapper.updateById(entity);
        UserModel user = Convert.convert(UserModel.class,entity);
        System.out.println(user.getEmail());
        return "你好，欢迎使用Visual Studio Code!";
    }
}