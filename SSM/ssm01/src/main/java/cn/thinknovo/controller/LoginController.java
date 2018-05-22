package cn.thinknovo.controller;

import cn.thinknovo.pojo.User;
import cn.thinknovo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thinknovo
 * Date: 2018/05/22 9:29
 * Description:
 * Version: V1.0
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/selectUserList", method = RequestMethod.GET)
    public String selectUserList() {
        List<User> userList = loginService.selectUserList();
        for(User user : userList) {
            System.out.println(user.getUsername());
        }
        // /WEB-INF/selectUserList.jsp
        return null;
    }
}
