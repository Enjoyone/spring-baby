package com.pro.baby.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ArticleType {
    @GeneratedValue
    @Id
    private int articleTypeID;

    private String articleTypeName;

    private LocalDate articleTypeCreateTime=LocalDate.now();
    private boolean status=true;


    public int getArticleTypeID() {
        return articleTypeID;
    }

    public void setArticleTypeID(int articleTypeID) {
        this.articleTypeID = articleTypeID;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    public LocalDate getArticleTypeCreateTime() {
        return articleTypeCreateTime;
    }

    public void setArticleTypeCreateTime(LocalDate articleTypeCreateTime) {
        this.articleTypeCreateTime = articleTypeCreateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
