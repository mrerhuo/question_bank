package online.jianchi.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import online.jianchi.webapi.mapper.UserMapper;
import online.jianchi.webapi.entity.UserEntity;

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
        List<UserEntity> userList = userMapper.selectList(null);
        if(userList!=null){
            for (UserEntity userModel : userList) {
                System.out.println(userModel.getName());;
            }
        }
        UserEntity entity=userMapper.selectById("1");
        System.out.println(entity.getName());
        return "你好，欢迎使用Visual Studio Code!";
    }
}