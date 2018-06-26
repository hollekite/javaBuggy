package com.lgs.dao;
import com.lgs.entity.User;


/**
 * 和User表和UserMapper对应的接口。该接口主要是定义了一些与User表操作相关的方法
 */

import java.util.List;

public interface UserMapper {

    /**
     * 查询所有的用户信息，并返回装有用户实体的List集合
     * @return 装有User 的List集合
     */
    List<User> SelectAll();

}