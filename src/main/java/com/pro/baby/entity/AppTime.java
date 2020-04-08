package com.pro.baby.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class AppTime {

    @Id
    @GeneratedValue
    private int appTimeID;


    private LocalDate startDay;

    private LocalDate stopDay;

    private LocalDate finalDay;

    private LocalTime startTime;
    private LocalTime stopTime;


    public int getAppTimeID() {
        return appTimeID;
    }

    public void setAppTimeID(int appTimeID) {
        this.appTimeID = appTimeID;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getStopDay() {
        return stopDay;
    }

    public void setStopDay(LocalDate stopDay) {
        this.stopDay = stopDay;
    }

    public LocalDate getFinalDay() {
        return finalDay;
    }

    public void setFinalDay(LocalDate finalDay) {
        this.finalDay = finalDay;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getStopTime() {
        return stopTime;
    }

    public void setStopTime(LocalTime stopTime) {
        this.stopTime = stopTime;
    }
}
