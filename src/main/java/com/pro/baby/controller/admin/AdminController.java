package com.pro.baby.controller.admin;

import com.pro.baby.service.admin.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String Admin(){
        return "admin/index/index";
    }

    @GetMapping("/adminLogin")
    public String AdminLogin(){
        return "admin/login/login";
    }

    @PostMapping("adminLogin")
    public String AdminLogin(Model model, String userID, String userPWD, HttpSession session){
        if(new AdminService().loginCheck(userID,userPWD)) {
            session.setAttribute("adminID", userID);
            return "redirect:admin";
        }else
            return  "redirect:adminLogin";
    }
}
