package com.pro.baby.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class DiaryComment {
    @GeneratedValue
    @Id
    private int diaryCommentID;

    @ManyToOne
    private Parent parent;
    @ManyToOne
    private Diary diary;


    private boolean commentLevel;

    private String content;

    private LocalDate commentTime=LocalDate.now();
    private boolean status=true;


    public int getDiaryCommentID() {
        return diaryCommentID;
    }

    public void setDiaryCommentID(int diaryCommentID) {
        this.diaryCommentID = diaryCommentID;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    public boolean isCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(boolean commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
