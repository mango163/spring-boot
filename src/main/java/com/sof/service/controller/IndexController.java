/**
 * 
 */
package com.sof.service.controller;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sof.service.model.User;
import com.sof.service.service.IUserService;

/**
 * @author Aaron
 */
@ApiIgnore // 禁止暴露此controller
@Controller
public class IndexController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "首页", notes = "")
    @RequestMapping("/")
    public String index(ModelMap map) {
        List<User> users = userService.selectByState(1);
        map.addAttribute("host", "http://www.richest007.net");
        System.out.println(users.get(0).getLoginName());
        return "index";
    }

    @RequestMapping("/infos")
    public String info(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "info";
    }
}
