package com.jxnu.service;

import com.jxnu.dao.UserMapper;
import com.jxnu.pojo.Users;

public class UserServiceImp implements UserService {
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Boolean userLogin(String username, String password) {
        return userMapper.userLogin(username, password)==null?false:true;
    }

    public String queryUserIdByUsername(String username) {
        return userMapper.queryUserIdByUsername(username);
    }
}
