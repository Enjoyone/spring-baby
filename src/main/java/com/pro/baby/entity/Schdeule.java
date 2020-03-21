package com.pro.baby.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Schdeule {
    @GeneratedValue
    @Id
    private int scheduleID;

    @ManyToOne
    private Parent parentID;

    private String scheduleTitle;
    private String scheduleContent;

    private LocalDate scheduleCreateTime;
    private LocalDate scheduleRemindTime;
    private String location;
    private boolean scheduleStatus;



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public Parent getParentID() {
        return parentID;
    }

    public void setParentID(Parent parentID) {
        this.parentID = parentID;
    }

    public String getScheduleTitle() {
        return scheduleTitle;
    }

    public void setScheduleTitle(String scheduleTitle) {
        this.scheduleTitle = scheduleTitle;
    }

    public String getScheduleContent() {
        return scheduleContent;
    }

    public void setScheduleContent(String scheduleContent) {
        this.scheduleContent = scheduleContent;
    }

    public LocalDate getScheduleCreateTime() {
        return scheduleCreateTime;
    }

    public void setScheduleCreateTime(LocalDate scheduleCreateTime) {
        this.scheduleCreateTime = scheduleCreateTime;
    }

    public LocalDate getScheduleRemindTime() {
        return scheduleRemindTime;
    }

    public void setScheduleRemindTime(LocalDate scheduleRemindTime) {
        this.scheduleRemindTime = scheduleRemindTime;
    }

    public boolean isScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(boolean scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

}
