package com.pro.baby.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AppointApplication {

    @Id
    @GeneratedValue
    private  int AppointApplicationID;

    @ManyToOne
    private Parent parent;

    @OneToOne
    private Address address;

    @OneToOne
    private AppTime appTime;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public AppTime getAppTime() {
        return appTime;
    }

    public void setAppTime(AppTime appTime) {
        this.appTime = appTime;
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
