package online.jianchi.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import online.jianchi.webapi.domain.entity.sys.SysDictGroup;
import online.jianchi.webapi.service.sys.IDictGroupService;


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
    private IDictGroupService dictGroupService;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String test() {
        SysDictGroup model=new SysDictGroup();
        model.setCreateBy("admin");
        model.setCreateTime();
        model.setGroupCode("groupCode2");
        model.setGroupName("分组");
        model.setRemark("测试");
        model.setSort("01");
        model.setStatus("1");
        model.setUpdateBy("admin");
        model.setUpdateTime();
        int i= dictGroupService.add(model);

        System.out.println(i);
        System.out.println(model.getGroupId());
        return "你好，欢迎使用Visual Studio Code!";
    }
}