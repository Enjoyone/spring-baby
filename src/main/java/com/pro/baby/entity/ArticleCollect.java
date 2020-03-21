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
    private Parent parentID;
    @ManyToOne
    private Article articleID;

    private LocalDate articleCollectTime;

    public int getArticleCollectID() {
        return articleCollectID;
    }

    public void setArticleCollectID(int articleCollectID) {
        this.articleCollectID = articleCollectID;
    }

    public Parent getParentID() {
        return parentID;
    }

    public void setParentID(Parent parentID) {
        this.parentID = parentID;
    }

    public Article getArticleID() {
        return articleID;
    }

    public void setArticleID(Article articleID) {
        this.articleID = articleID;
    }

    public LocalDate getArticleCollectTime() {
        return articleCollectTime;
    }

    public void setArticleCollectTime(LocalDate articleCollectTime) {
        this.articleCollectTime = articleCollectTime;
    }

}
