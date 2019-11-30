package com.jxnu.controller;

import com.jxnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UserController {
    @Autowired
    @Qualifier("UserServiceImp")
    private UserService userService;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, String username, String password) {
        Boolean b = userService.userLogin(username, password);
        System.out.println("密码"+b);
        if (b == true) {
            HttpSession session = request.getSession();
            String userid = userService.queryUserIdByUsername(username);
            session.setAttribute("userid",userid);
            session.setAttribute("username",username);
            System.out.println("用户名是:"+username);
            return "forward:main";
        } else {
        return "redirect:index.jsp";
        }
    }

    @RequestMapping(value = "/toUserview")
    public String toUserview(){
        return "userview";
    }

    @RequestMapping(value = "/toMessageview")
    public String toMessage(){
        return "messageView";
    }

}
