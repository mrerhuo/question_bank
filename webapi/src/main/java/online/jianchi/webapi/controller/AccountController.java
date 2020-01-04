package online.jianchi.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import online.jianchi.webapi.mapper.UserMapper;
import online.jianchi.webapi.model.UserModel;

/*
 *作者：二先生
 *创建时间：2020年01月04日
 *说明：登录控制器
*/
@Api(tags = "account", description = "登录控制器")
@RestController
@RequestMapping("/account")
public class AccountController {
    private UserMapper userMapper;
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        List<UserModel> userList = userMapper.selectList(null);
        return "你好，欢迎使用Visual Studio Code!";
    }
}