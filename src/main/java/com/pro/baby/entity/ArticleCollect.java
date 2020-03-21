package com.pro.baby.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class ArticleCollect {
    @GeneratedValue
    @Id
    private int articleCollectID;
    @ManyToOne
    private Parent parent;
    @ManyToOne
    private Article article;

    private LocalDate articleCollectTime=LocalDate.now();


    public int getArticleCollectID() {
        return articleCollectID;
    }

    public void setArticleCollectID(int articleCollectID) {
        this.articleCollectID = articleCollectID;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public LocalDate getArticleCollectTime() {
        return articleCollectTime;
    }

    public void setArticleCollectTime(LocalDate articleCollectTime) {
        this.articleCollectTime = articleCollectTime;
    }
}
