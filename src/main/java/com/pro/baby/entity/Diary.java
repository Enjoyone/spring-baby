package com.pro.baby.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Diary {
    @GeneratedValue
    @Id
    private int diaryID;
    @ManyToOne
    private Parent parentID;
    @ManyToOne
    private DiaryType diaryType;// id及name

    private String diaryTitle;
    private String diaryContent;

    private LocalDate createTime;
    private int commentNum;
    private boolean diaryStatus;

    public DiaryType getDiaryType() {
        return diaryType;
    }

    public void setDiaryType(DiaryType diaryType) {
        this.diaryType = diaryType;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getDiaryID() {
        return diaryID;
    }

    public void setDiaryID(int diaryID) {
        this.diaryID = diaryID;
    }

    public Parent getParentID() {
        return parentID;
    }

    public void setParentID(Parent parentID) {
        this.parentID = parentID;
    }


    public String getDiaryTitle() {
        return diaryTitle;
    }

    public void setDiaryTitle(String diaryTitle) {
        this.diaryTitle = diaryTitle;
    }

    public String getDiaryContent() {
        return diaryContent;
    }

    public void setDiaryContent(String diaryContent) {
        this.diaryContent = diaryContent;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public boolean isDiaryStatus() {
        return diaryStatus;
    }

    public void setDiaryStatus(boolean diaryStatus) {
        this.diaryStatus = diaryStatus;
    }

}
