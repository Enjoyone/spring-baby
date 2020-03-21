package com.pro.baby.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Appoint {
    @GeneratedValue
    @Id
    private int appointID;
    @ManyToOne
    private Parent parentID;
    @ManyToOne
    private Parent par_parentID;
    private String appointPlace;


    private LocalDate appointTime;
    private LocalDate appointCreateTime;

    private String appointLevel;
    private String appointComment;
    private boolean appointStatus;

    public int getAppointID() {
        return appointID;
    }

    public void setAppointID(int appointID) {
        this.appointID = appointID;
    }

    public Parent getParentID() {
        return parentID;
    }

    public void setParentID(Parent parentID) {
        this.parentID = parentID;
    }

    public Parent getPar_parentID() {
        return par_parentID;
    }

    public void setPar_parentID(Parent par_parentID) {
        this.par_parentID = par_parentID;
    }

    public String getAppointPlace() {
        return appointPlace;
    }

    public void setAppointPlace(String appointPlace) {
        this.appointPlace = appointPlace;
    }

    public LocalDate getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(LocalDate appointTime) {
        this.appointTime = appointTime;
    }

    public LocalDate getAppointCreateTime() {
        return appointCreateTime;
    }

    public void setAppointCreateTime(LocalDate appointCreateTime) {
        this.appointCreateTime = appointCreateTime;
    }

    public String getAppointLevel() {
        return appointLevel;
    }

    public void setAppointLevel(String appointLevel) {
        this.appointLevel = appointLevel;
    }

    public String getAppointComment() {
        return appointComment;
    }

    public void setAppointComment(String appointComment) {
        this.appointComment = appointComment;
    }

    public boolean isAppointStatus() {
        return appointStatus;
    }

    public void setAppointStatus(boolean appointStatus) {
        this.appointStatus = appointStatus;
    }

}
