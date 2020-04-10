package com.pro.baby.service.article;


import com.pro.baby.entity.Article;
import com.pro.baby.entity.ArticleType;
import com.pro.baby.entity.Diary;
import com.pro.baby.entity.DiaryType;
import com.pro.baby.repository.ArticleRepository;
import com.pro.baby.repository.ArticleTypeRepository;
import com.pro.baby.repository.DiaryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    // 写文章
    public int addArticle(Article article) {

        articleRepository.save(article);
        return article.getArticleID();

    }

    //  back类型
    public List<ArticleType> backArticleTypes() {
        List<ArticleType> articleTypes = articleTypeRepository.findAll();
        return articleTypes;
    }

    //  返回单一类型
    public ArticleType getOne(int articleTypeID) {
        return articleTypeRepository.getOne(articleTypeID);
    }


    //    展示文章
    public Article showArticle(int articleID) {

        return articleRepository.getOne(articleID);
    }

    //返回所有文章
    public List<Article> articles() {
        return articleRepository.findAll();
    }





//    修改文章

    public void updateArticle(Article article){
        //articleRepository.updateArticleById(article.getArticleID(),article.getArticleTitle(),article.getArticleContent(),article.getArticleType());
    }


//    删除日记


//    类型


    //    添加类型

    public ArticleType addArticleType(ArticleType articleType) {
        return articleTypeRepository.save(articleType);
    }


    public void deleteArticleByID(int articleID) {
        articleRepository.deleteById(articleID);
    }
}
