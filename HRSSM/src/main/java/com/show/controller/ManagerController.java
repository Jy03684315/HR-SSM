package com.show.controller;

import com.show.model.Manager;
import com.show.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Show on 2018/7/30.
 */
@Controller
public class ManagerController {
    @Resource
    private ManagerService managerService;
    @RequestMapping("/toMLogin")
    public String toMLogin(){
        return "loginManager";
    }
    @RequestMapping("/mLogin")
    public String loginManager(Manager manager, HttpSession session, Model model){
        Manager manager1=managerService.getManager(manager);
        if (manager1==null){
            model.addAttribute("failML","用户名或密码错误");
            return "loginManager";
        }
        session.setAttribute("m",manager1);
        return "managerConsole";
    }
    @RequestMapping("/mConsole")
    public String mConsole(){
        return "managerConsole";
    }
}
