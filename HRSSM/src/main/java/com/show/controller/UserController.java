package com.show.controller;

import com.show.model.User;
import com.show.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import static javax.swing.text.html.CSS.getAttribute;

/**
 * Created by Show on 2018/7/25.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "registerUser";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "loginUser";
    }
    @RequestMapping("/register")
    public String addUser(User user, HttpSession session, Model model){
        User user1=userService.getUserByName(user);
        if (user1!=null){
            model.addAttribute("failR","用户已存在");
            return "registerUser";
        }
        userService.addUser(user);
        User user2=userService.getUserByNamePass(user);
        session.setAttribute("u",user2);
        return "forward:";
    }
    @RequestMapping("/login")
    public String loginUser(User user, HttpSession session, Model model){
        User user1=userService.getUserByNamePass(user);
        if (user1==null){
            model.addAttribute("failL","用户名或密码错误");
            return "loginUser";
        }
        session.setAttribute("u",user1);
        return "forward:";
    }
}
