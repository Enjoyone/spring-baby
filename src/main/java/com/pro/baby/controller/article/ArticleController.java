package com.pro.baby.controller.article;


import com.pro.baby.entity.*;
import com.pro.baby.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

//写文章

    @GetMapping("/articleWrite")
    public String toArticleWrite(Model model) {
        List<ArticleType> articleTypes=articleService.backArticleTypes();
        model.addAttribute("articleTypes",articleTypes);
        return "article/articleWrite";
    }


    @PostMapping("/articleWrite")
    @ResponseBody
    public int articleWrite(String articleTitle,String articleContent,int articleTypeID) {

        Article article=new Article();
        ArticleType articleType=articleService.getOne(articleTypeID);

        article.setArticleTitle(articleTitle);
        article.setArticleType(articleType);
        article.setArticleContent(articleContent);

        return articleService.addArticle(article);
    }



//    删除文章


//    修改文章
    @GetMapping("/updateArticle")
    public String updateArticle(Model model,int articleID){
        Article article = articleService.showArticle(articleID);
        model.addAttribute("article", article);
        return "/article/articleUpdate";
    }

    @PostMapping("/updateArticle")
    public String updateArticle(String articleTitle,String articleContent,int articleTypeID) {
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
    public String addArticleType(ArticleType articleType) {
          articleService.addArticleType(articleType);
        return "1";
    }



//    2 修改


//    3 删除


}
