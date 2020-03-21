package com.pro.baby.entity;

import org.apache.tomcat.jni.Local;

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
    private Article article;
    @ManyToOne
    private Parent parent;
    private String articleCommentContent;

    private LocalDate commentTime = LocalDate.now();
    private boolean status = true;


    public int getArticleCommentID() {
        return articleCommentID;
    }

    public void setArticleCommentID(int articleCommentID) {
        this.articleCommentID = articleCommentID;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getArticleCommentContent() {
        return articleCommentContent;
    }

    public void setArticleCommentContent(String articleCommentContent) {
        this.articleCommentContent = articleCommentContent;
    }

    public LocalDate getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDate commentTime) {
        this.commentTime = commentTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
