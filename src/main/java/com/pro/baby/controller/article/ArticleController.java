package com.pro.baby.controller.article;


import com.pro.baby.entity.*;
import com.pro.baby.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

//写文章

    @GetMapping("/articleWrite" )
    public String toArticleWrite(Model model , HttpSession session) {
        if(session.getAttribute("adminID")!=null) {
            List<ArticleType> articleTypes = articleService.backArticleTypes();
            model.addAttribute("articleTypes", articleTypes);
            return "article/articleWrite";
        }
        else
            return "redirect:adminLogin";
    }


    @PostMapping("/articleWrite")
    public String articleWrite(String articleTitle,String articleContent,String articleTypeID,HttpSession session) {

        Article article=new Article();
        ArticleType articleType=articleService.getOne(Integer.parseInt(articleTypeID));

        article.setArticleTitle(articleTitle);
        article.setArticleType(articleType);
        article.setArticleContent(articleContent);

        return "redirect:/showArticle?articleID="+articleService.addArticle(article);
    }



//    删除文章
    @GetMapping("/deleteArticle")
    @ResponseBody
    public String deleteArticle(int articleID,HttpSession session){
        if(session.getAttribute("adminID")!=null) {
            articleService.deleteArticleByID(articleID);
            return "1";
        }
        else
            return "redirect:adminLogin";
    }


//    修改文章
    @GetMapping("/updateArticle")
    public String updateArticle(Model model,String articleID,HttpSession session){
        if(session.getAttribute("adminID")!=null) {
            int id = Integer.parseInt(articleID);
            List<ArticleType> articleTypes = articleService.backArticleTypes();
            model.addAttribute("articleTypes", articleTypes);
            Article article = articleService.showArticle(id);
            model.addAttribute("article", article);
            return "/article/articleUpdate";
        }
        else
            return "redirect:adminLogin";
    }

    @PostMapping("/updateArticle")
    public String updateArticle(String articleTitle,String articleContent,int articleTypeID,HttpSession session) {
        Article article=new Article();
        ArticleType articleType=articleService.getOne(articleTypeID);

        article.setArticleTitle(articleTitle);
        article.setArticleType(articleType);
        article.setArticleContent(articleContent);
       // articleService.updateArticle(article);
        return "redirect:/showArticle?articleI="+article.getArticleID();
    }


//    查看文章

    @GetMapping("/showArticle")
    public String diaryShow(int articleID, Model model) {
        Article article = articleService.showArticle(articleID);
        model.addAttribute("article", article);

        return "article/articleShow";
    }


//    @GetMapping("/findAllArticle")
//    public String findAllArticle(){
//        List<Article> articles;
//        articles = articleService.articles();
//
//
//        return articles;
//    }



    //    类型
//    1 添加
    @GetMapping("/addArticleType")
    @ResponseBody
    public String addArticleType(ArticleType articleType,HttpSession session) {
          articleService.addArticleType(articleType);
        return "1";
    }



//    2 修改


//    3 删除


}
