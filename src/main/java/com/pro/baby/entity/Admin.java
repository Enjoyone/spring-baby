package com.pro.baby.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
    @Id
    private String userID;

    private String passwod;
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getPasswod() {
        return passwod;
    }
    public void setPasswod(String passwod) {
        this.passwod = passwod;
    }
}
