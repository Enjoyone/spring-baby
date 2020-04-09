package com.pro.baby.repository;

import com.pro.baby.entity.Article;
import com.pro.baby.entity.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    //修改文章，sql语句未写
   // @Modifying
    //@Query(value = "update Article set name = :name where id = :id",nativeQuery = true)
    //void updateArticleById(int articleID, String articleTitle, String articleContent, ArticleType articleType);
}
