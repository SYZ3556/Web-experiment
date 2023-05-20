package com.experiment.controller;

import com.experiment.pojo.User;
import com.experiment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, User user) {
        User user1 = userService.findUser(user);
        if (user1 != null) {
            request.setAttribute("wrongIdOrPassword", "");
            User.name = user.getEmail();
            return "redirect:/showAllCourses";
        }
        request.setAttribute("wrongIdOrPassword", "账号或密码错误！请重新输入！");
        return "login";
    }
}
