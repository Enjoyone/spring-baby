package com.pro.baby.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class ArticleComment {
    @GeneratedValue
    @Id
    private int articleCommentID;
    @ManyToOne
    private Article articleID;
    @ManyToOne
    private Parent parentID;
    private String articleCommentContent;

    private LocalDate articleCommentTime;
    private boolean articleCommentStatus;

    public int getArticleCommentID() {
        return articleCommentID;
    }

    public void setArticleCommentID(int articleCommentID) {
        this.articleCommentID = articleCommentID;
    }

    public Article getArticleID() {
        return articleID;
    }

    public void setArticleID(Article articleID) {
        this.articleID = articleID;
    }

    public Parent getParentID() {
        return parentID;
    }

    public void setParentID(Parent parentID) {
        this.parentID = parentID;
    }

    public String getArticleCommentContent() {
        return articleCommentContent;
    }

    public void setArticleCommentContent(String articleCommentContent) {
        this.articleCommentContent = articleCommentContent;
    }

    public LocalDate getArticleCommentTime() {
        return articleCommentTime;
    }

    public void setArticleCommentTime(LocalDate articleCommentTime) {
        this.articleCommentTime = articleCommentTime;
    }

    public boolean isArticleCommentStatus() {
        return articleCommentStatus;
    }

    public void setArticleCommentStatus(boolean articleCommentStatus) {
        this.articleCommentStatus = articleCommentStatus;
    }

}
