package com.pro.baby.entity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Image {

    @GeneratedValue
    @Id
    private int imageID;

    private String url;
    private String imageNmae;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getKidID() {
        return kidID;
    }

    public void setKidID(int kidID) {
        this.kidID = kidID;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    private int kidID;
    private int articleID;


    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageNmae() {
        return imageNmae;
    }

    public void setImageNmae(String imageNmae) {
        this.imageNmae = imageNmae;
    }
}
