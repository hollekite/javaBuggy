package cn.thinknovo.service;

import cn.thinknovo.pojo.User;
import cn.thinknovo.pojo.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thinknovo
 * Date: 2018/05/22 9:29
 * Description:
 * Version: V1.0
 */
@Service
public class LoginService {
    /*
         @Service
        @Component
        @Controller
        目前版本中。spring定义都是一个意思，都是生成一个bean对象
        spring建议我们应该Service和Controller定义出来，
        通过注解的方式可以直接看懂是什么关联
        Controller针对的是spring mvc
        Service针对的是spring ioc控制管理
     */
    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> selectUserList() {
        return userMapper.selectUserList();
    }
}
