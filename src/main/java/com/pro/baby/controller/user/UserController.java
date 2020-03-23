package com.pro.baby.controller.user;


import com.pro.baby.entity.Parent;
import com.pro.baby.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(value = "parent")
public class UserController {
    @Autowired
    private UserService userService;


//    注册

    @GetMapping("/register")
    public String toAddUser() {
        return "loginRegister/register";
    }

    @PostMapping("register")
    public String addUser(@ModelAttribute("parent") Parent parent) {
        Parent parent1 = userService.addUser(parent);
        return "loginRegister/success";
    }


    //    登录
    @GetMapping("/login")
    public String toLogin(){
        return "loginRegister/login";
    }
    @PostMapping("/login")
    public String login(Model model, String userName, String pwd) {
        Parent parent = userService.loginCheck(userName, pwd);
        if (parent != null) {
            model.addAttribute("parent", parent);
            return "forward:index/index";

        } else {
            return "redirect:index/index";
        }

    }

    //    退出
    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
//清空session
        sessionStatus.setComplete();

        return "redirect:index/index";
    }
}











