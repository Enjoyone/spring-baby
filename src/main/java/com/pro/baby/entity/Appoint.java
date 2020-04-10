package com.pro.baby.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Appoint {

    @Id
    @GeneratedValue
    private int appointID;

    //    发起者
    @OneToOne
    private Parent parent;
    //地址
    @OneToOne
    private Address address;
    //时间
    @OneToOne
    private AppTime appTime;
    //kid成员集合
    @OneToMany
    private Set<Kid> kids = new HashSet<>();
    //parents
    @OneToMany
    private Set<Parent> parents = new HashSet<>();

    //    备注
    private String ps;

    //    评论
    @OneToMany
    private Set<AppointComment> appointComment = new HashSet<>();


    //  创建时间
    private LocalDateTime appointCreateTime = LocalDateTime.now();


    private boolean stop = false;  //结束停止加入，并确认最后时间
    private boolean haveDone = false;//  判断是否完成本次预约
    private boolean status = true;  //是否失效


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

    public Set<Kid> getKids() {
        return kids;
    }

    public void setKids(Set<Kid> kids) {
        this.kids = kids;
    }

    public Set<Parent> getParents() {
        return parents;
    }

    public void setParents(Set<Parent> parents) {
        this.parents = parents;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public Set<AppointComment> getAppointComment() {
        return appointComment;
    }

    public void setAppointComment(Set<AppointComment> appointComment) {
        this.appointComment = appointComment;
    }

    public LocalDateTime getAppointCreateTime() {
        return appointCreateTime;
    }

    public void setAppointCreateTime(LocalDateTime appointCreateTime) {
        this.appointCreateTime = appointCreateTime;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public boolean isHaveDone() {
        return haveDone;
    }

    public void setHaveDone(boolean haveDone) {
        this.haveDone = haveDone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
