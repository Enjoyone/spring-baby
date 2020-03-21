package com.pro.baby.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class DiaryType {
    @GeneratedValue
    @Id
    private int diaryTypeID;

    @ManyToOne
    private Parent parentID;

    private String diaryTypeName;

    private LocalDate createTime;
    private boolean diaryTypeStatus;
    public int getDiaryTypeID() {
        return diaryTypeID;
    }
    public void setDiaryTypeID(int diaryTypeID) {
        this.diaryTypeID = diaryTypeID;
    }

    public Parent getParentID() {
        return parentID;
    }
    public void setParentID(Parent parentID) {
        this.parentID = parentID;
    }
    public String getDiaryTypeName() {
        return diaryTypeName;
    }
    public void setDiaryTypeName(String diaryTypeName) {
        this.diaryTypeName = diaryTypeName;
    }
    public LocalDate getCreateTime() {
        return createTime;
    }
    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }
    public boolean isDiaryTypeStatus() {
        return diaryTypeStatus;
    }
    public void setDiaryTypeStatus(boolean diaryTypeStatus) {
        this.diaryTypeStatus = diaryTypeStatus;
    }

}
