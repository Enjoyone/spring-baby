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
    private Parent parent;

    private String diaryTypeName;

    private LocalDate createTime=LocalDate.now();
    private boolean status=true;


    public int getDiaryTypeID() {
        return diaryTypeID;
    }

    public void setDiaryTypeID(int diaryTypeID) {
        this.diaryTypeID = diaryTypeID;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
