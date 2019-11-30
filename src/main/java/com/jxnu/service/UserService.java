package com.jxnu.service;

import com.jxnu.pojo.Users;

public interface UserService {
    Boolean userLogin(String username,String password);
    String queryUserIdByUsername(String username);
}
