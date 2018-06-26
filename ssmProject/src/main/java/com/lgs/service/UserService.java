package com.lgs.service;

import com.lgs.dao.UserMapper;
import com.lgs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 说明：${Description}
 * 作者：${AUTHER}
 * 创建日期：2018-06-25
 * 版本：${Version}
 */
@Service
public class UserService {

    @Autowired
    private   UserMapper userMapper;

    public UserService() {
        System.out.println("----------UserService----");
    }

    public List<User> getUsers()
    {
        System.out.println("-----getUsers-----");
        return userMapper.SelectAll(); }

}
