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
    private Set<Kid> kids=new HashSet<Kid>();


    private String appointPlace;


    private LocalDateTime appointTime;

    private LocalDate appointCreateTime=LocalDate.now();

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

    public String getAppointPlace() {
        return appointPlace;
    }

    public void setAppointPlace(String appointPlace) {
        this.appointPlace = appointPlace;
    }

    public LocalDateTime getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(LocalDateTime appointTime) {
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
