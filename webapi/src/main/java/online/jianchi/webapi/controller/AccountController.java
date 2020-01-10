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
import online.jianchi.webapi.model.UserModel;
import online.jianchi.webapi.mapper.sys.UserMapper;
import online.jianchi.webapi.entity.SysUserEntity;

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
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        // List<SysUserEntity> userList = userMapper.selectList(null);
        
        Wrapper<SysUserEntity> wrapper = new QueryWrapper<SysUserEntity>().lambda().like(SysUserEntity::getName, "n");
        List<SysUserEntity> list=userMapper.selectList(wrapper);
        if(list!=null){
            for (SysUserEntity userModel : list) {
                System.out.println(userModel.getName());;
            }
        }
        SysUserEntity entity=userMapper.selectByStringId("3");
        System.out.println(entity.getName());
        // entity.setName("name");
        // userMapper.updateById(entity);
        UserModel user = Convert.convert(UserModel.class,entity);
        System.out.println(user.getEmail());
        return "你好，欢迎使用Visual Studio Code!";
    }
}