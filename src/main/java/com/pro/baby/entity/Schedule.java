package com.pro.baby.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Schedule {
    @GeneratedValue
    @Id
    private int scheduleID;

    @ManyToOne
    private Parent parent;

    private String scheduleTitle;
    private String scheduleContent;

    private LocalDate scheduleCreateTime=LocalDate.now();
    private LocalDate scheduleRemindTime;
    private String location;
    private boolean scheduleStatus=true;


    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(boolean scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }
}
