package com.pro.baby.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AppointApplication {

    @Id
    @GeneratedValue
    private  int AppointApplicationID;

    @ManyToOne
    private Parent parent;


    private  LocalDate startTime;

    private  LocalDate stopTime;

    private String time;

    private boolean status=true;

    @OneToMany
    private Set<Kid> kids=new HashSet<>();


    public int getAppointApplicationID() {
        return AppointApplicationID;
    }

    public void setAppointApplicationID(int appointApplicationID) {
        AppointApplicationID = appointApplicationID;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getStopTime() {
        return stopTime;
    }

    public void setStopTime(LocalDate stopTime) {
        this.stopTime = stopTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Kid> getKids() {
        return kids;
    }

    public void setKids(Set<Kid> kids) {
        this.kids = kids;
    }
}
