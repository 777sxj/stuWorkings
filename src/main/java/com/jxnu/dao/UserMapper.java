package com.jxnu.dao;

import com.jxnu.pojo.Users;

public interface UserMapper {
    Users userLogin(String username,String password);
    String queryUserIdByUsername(String username);
}
