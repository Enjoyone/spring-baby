package com.pro.baby.controller.article;


import com.pro.baby.entity.Article;
import com.pro.baby.entity.ArticleType;
import com.pro.baby.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

//写文章

    @GetMapping("/articleWrite")
    public String articleWrite() {
        return "article/articleWrite";
    }


    @PostMapping("articleWrite")
    public String articleWrite2(Article article) {
        articleService.addArticle(article);
        return "article/articleShow";
    }


//    删除文章


//    修改文章


//    查看文章


    //    类型
//    1 添加
    @GetMapping("/addArticleType")
    @ResponseBody
    public ArticleType addArticleType(ArticleType articleType) {
        System.out.println(articleType.getArticleTypeName());
        return  articleService.addArticleType(articleType);
    }


//    2 修改


//    3 删除


}
