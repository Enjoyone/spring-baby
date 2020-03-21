package com.pro.baby.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Article {
    @GeneratedValue
    @Id
    private int articleID;

    @ManyToOne
    private ArticleType articleType;

    @ManyToOne
    private Parent parent;

    private String articleTitle;
    private String articleContent;

    private LocalDate articleCreateTime=LocalDate.now();
    private boolean status=true;

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public LocalDate getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(LocalDate articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
