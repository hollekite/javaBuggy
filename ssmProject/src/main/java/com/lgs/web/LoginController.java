package com.lgs.web;



import com.alibaba.fastjson.JSON;
import com.lgs.entity.User;
import com.lgs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 说明：${Description}
 * 作者：${AUTHER}
 * 创建日期：2018-06-25
 * 版本：${Version}
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
   /* @ResponseBody  //返回json数据需要加此注解*/
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String UserLogin()
    {
        System.out.println("我被访问啦！");
        List<User> users = userService.getUsers();
        //利用fastjson将users集合转化为json数据
        String json = JSON.toJSON(users).toString().toString();
        System.out.println(json);
        /*return json;*/  //返回json数据
        /**
         * org.springframework.web.util.NestedServletException:
         * Handler processing failed; nested exception is java.lang.NoClassDefFoundError:
         * javax/servlet/jsp/jstl/core/Config
         *
         * 在环境搭建好之后运行的时候报这个错误，原因在tomcat本身不是一个真正的Java EE web容器。
         * 因此需要添加jstl的jar。需要在Maven的POM中已经添加了相应的依赖包坐标。
         * 参考文章：https://my.oschina.net/happyBKs/blog/691502
         */
        return "welcome";
    }

}
