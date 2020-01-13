package online.jianchi.webapi.controller.sys;

import java.util.HashMap;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.convert.Convert;
import io.swagger.annotations.Api;
import online.jianchi.webapi.base.result.Result;
import online.jianchi.webapi.domain.entity.sys.SysUser;
import online.jianchi.webapi.domain.mapper.sys.UserMapper;
import online.jianchi.webapi.domain.vo.sys.UserModel;

/*
 *作者：二先生
 *创建时间：2020年01月04日
 *说明：登录控制器
*/
@Api(tags = "test", description = "登录控制器")
@RestController
@RequestMapping("/test")
public class TestController {
    
    @Autowired
    private UserMapper userMapper;
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Result<List<SysUser>> test() {
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
        return Result.success(list);
    }
    @RequestMapping(value = "/error1", method = RequestMethod.GET)
    public HashMap<String, Object> helloError() throws Exception {
        throw new Exception("helloError");
    }

    @RequestMapping(value = "/error2", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Java的异常")
    public HashMap<String, Object> helloJavaError() throws Exception {
        throw new Exception("helloError");
    }
}