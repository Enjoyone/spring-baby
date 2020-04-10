package com.pro.baby.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AppointComment {

    @Id
    @GeneratedValue
    private int appointCommentID;

    @OneToOne
    private Parent parent;

    private int level;

    private String content;

    public int getAppointCommentID() {
        return appointCommentID;
    }

    public void setAppointCommentID(int appointCommentID) {
        this.appointCommentID = appointCommentID;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
