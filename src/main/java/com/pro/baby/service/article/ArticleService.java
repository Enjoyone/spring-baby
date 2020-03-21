package com.pro.baby.service.article;


import com.pro.baby.entity.Article;
import com.pro.baby.entity.ArticleType;
import com.pro.baby.repository.ArticleRepository;
import com.pro.baby.repository.ArticleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

@Autowired
    private ArticleRepository articleRepository;


// 写文章
    public Article addArticle(Article article){

        return articleRepository.save(article);

    }


//    添加类型
    @Autowired
    private ArticleTypeRepository articleTypeRepository;
    public ArticleType addArticleType(ArticleType articleType){
        return  articleTypeRepository.save(articleType);
    }



}
