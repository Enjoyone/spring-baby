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
    private Parent parent;

    @ManyToOne
    private Parent parent2;


    private String appointPlace;

    private LocalDate appointTime;

    private LocalDate appointCreateTime=LocalDate.now();

    private String appointLevel;
    private String appointComment;
    private boolean status=true;

    public int getAppointID() {
        return appointID;
    }

    public void setAppointID(int appointID) {
        this.appointID = appointID;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Parent getParent2() {
        return parent2;
    }

    public void setParent2(Parent parent2) {
        this.parent2 = parent2;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
