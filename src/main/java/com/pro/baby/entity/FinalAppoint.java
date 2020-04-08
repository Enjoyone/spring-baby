package com.pro.baby.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FinalAppoint {
    @GeneratedValue
    @Id
    private int finalAppointID;

    @OneToOne
    private AppointApplication appointApplication;

    @OneToMany
    private Set<Parent> parents=new HashSet<>();

    @OneToMany
    private Set<Kid> kids=new HashSet<>();

    @OneToOne
    private AppTime appTime;

    private LocalDateTime appointCreateTime=LocalDateTime.now();

    private String appointLevel;
    private String appointComment;
    private boolean status=true;


    public int getFinalAppointID() {
        return finalAppointID;
    }

    public void setFinalAppointID(int finalAppointID) {
        this.finalAppointID = finalAppointID;
    }

    public AppointApplication getAppointApplication() {
        return appointApplication;
    }

    public void setAppointApplication(AppointApplication appointApplication) {
        this.appointApplication = appointApplication;
    }

    public Set<Parent> getParents() {
        return parents;
    }

    public void setParents(Set<Parent> parents) {
        this.parents = parents;
    }

    public Set<Kid> getKids() {
        return kids;
    }

    public void setKids(Set<Kid> kids) {
        this.kids = kids;
    }

    public AppTime getAppTime() {
        return appTime;
    }

    public void setAppTime(AppTime appTime) {
        this.appTime = appTime;
    }

    public LocalDateTime getAppointCreateTime() {
        return appointCreateTime;
    }

    public void setAppointCreateTime(LocalDateTime appointCreateTime) {
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
