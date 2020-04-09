package com.pro.baby.controller.admin;

import com.pro.baby.entity.Article;
import com.pro.baby.entity.Parent;
import com.pro.baby.service.admin.AdminService;
import com.pro.baby.service.article.ArticleService;
import com.pro.baby.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String Admin(Model model){

        List<Article> articles;
        articles= articleService.articles();
        model.addAttribute("articles",articles);

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


//    @GetMapping("/adminAffair")
//    public void adminAffair(String operateType){
//        if(operateType.equals("userStatus")){
//
//        }
//    }

    @GetMapping("/adminWeb/normalUser")
    public  String normalUserWeb(Model model){
        List<Parent> normalUser ;
        normalUser=userService.AllParents();
        model.addAttribute("normalUser",normalUser);
        return "admin/user/normalUser";
    }

    @GetMapping("/adminWeb/article")
    public String articleWeb(Model model,String changeBack,String pageIndex){
        List<Article> articleList;
        if(changeBack!=null){
            int pageIndexInt =Integer.parseInt(String.valueOf(pageIndex));
            articleList=adminService.articlePageDao(pageIndexInt,10);
            model.addAllAttributes(articleList);
            return null;
        }
        articleList= adminService.articlePageDao(1,10);
        model.addAllAttributes(articleList);
        return "/admin/article/article";
    }


    @GetMapping("/adminWeb/diary")
    public String centerWeb(){
        return "/admin/center/center";
    }

    //修改用户状态
    @GetMapping("/adminAffair")
    public String changeUserStatus(String operateCon,String userID){
        System.out.println("change1111111");
        boolean toStatus = !operateCon.equals("lock");
//        放回用户修改后的状态，和是否修改成功
        List<Boolean> result=new ArrayList<>();
        result=adminService.changeUserStatus(userID,toStatus);
//		[0]  true 表示修改成功    [1] 表示最终状态
        String finalStatus=null;

        if (result.get(0)) {
//			修改成功
           return finalStatus=result.get(1).equals(true)?"1":"0";
//            model.addAttribute(finalStatus);
        }else{
//            model.addAttribute("-1");
            return  "-1";
        }
    }

}
