package com.pro.baby.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Kid {
    @GeneratedValue
    @Id
    private int kidID;

    @ManyToOne
    private Parent parent;

    private String name;
    private String gender;
    private LocalDate birth;
    private boolean status = true;


    public int getKidID() {
        return kidID;
    }

    public void setKidID(int kidID) {
        this.kidID = kidID;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
