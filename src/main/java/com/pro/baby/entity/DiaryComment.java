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
    private Parent parentID;
    @ManyToOne
    private Diary diaryID;

    private int parentDiaryCommentID;
    @ManyToOne
    private Parent parentDiaryCommentParentID;

    private int replyDiaryCommentID;
    @ManyToOne
    private Parent replyDiaryCommentParentID;


    private boolean commentLevel;
    private String diaryCommentContent;

    private LocalDate diaryCommentTime;
    private boolean diaryCommentStatus;
    public int getDiaryCommentID() {
        return diaryCommentID;
    }
    public void setDiaryCommentID(int diaryCommentID) {
        this.diaryCommentID = diaryCommentID;
    }
    public Parent getParentID() {
        return parentID;
    }
    public void setParentID(Parent parentID) {
        this.parentID = parentID;
    }
    public Diary getDiaryID() {
        return diaryID;
    }
    public void setDiaryID(Diary diaryID) {
        this.diaryID = diaryID;
    }
    public int getParentDiaryCommentID() {
        return parentDiaryCommentID;
    }
    public void setParentDiaryCommentID(int parentDiaryCommentID) {
        this.parentDiaryCommentID = parentDiaryCommentID;
    }
    public Parent getParentDiaryCommentParentID() {
        return parentDiaryCommentParentID;
    }
    public void setParentDiaryCommentParentID(Parent parentDiaryCommentParentID) {
        this.parentDiaryCommentParentID = parentDiaryCommentParentID;
    }
    public int getReplyDiaryCommentID() {
        return replyDiaryCommentID;
    }
    public void setReplyDiaryCommentID(int replyDiaryCommentID) {
        this.replyDiaryCommentID = replyDiaryCommentID;
    }
    public Parent getReplyDiaryCommentParentID() {
        return replyDiaryCommentParentID;
    }
    public void setReplyDiaryCommentParentID(Parent replyDiaryCommentParentID) {
        this.replyDiaryCommentParentID = replyDiaryCommentParentID;
    }
    public boolean isCommentLevel() {
        return commentLevel;
    }
    public void setCommentLevel(boolean commentLevel) {
        this.commentLevel = commentLevel;
    }
    public String getDiaryCommentContent() {
        return diaryCommentContent;
    }
    public void setDiaryCommentContent(String diaryCommentContent) {
        this.diaryCommentContent = diaryCommentContent;
    }
    public LocalDate getDiaryCommentTime() {
        return diaryCommentTime;
    }
    public void setDiaryCommentTime(LocalDate diaryCommentTime) {
        this.diaryCommentTime = diaryCommentTime;
    }
    public boolean isDiaryCommentStatus() {
        return diaryCommentStatus;
    }
    public void setDiaryCommentStatus(boolean diaryCommentStatus) {
        this.diaryCommentStatus = diaryCommentStatus;
    }

}
