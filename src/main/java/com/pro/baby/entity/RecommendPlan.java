package com.pro.baby.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class RecommendPlan {
    @GeneratedValue
    @Id
    private int recommendPlanID;

    @ManyToOne
    private Parent parent;

    private String recommendPlanTitle;
    private String recommendPlanContent;

    private LocalDate recommendPlanRemindTime;
    private boolean recommendPlanStatus=true;


    public int getRecommendPlanID() {
        return recommendPlanID;
    }

    public void setRecommendPlanID(int recommendPlanID) {
        this.recommendPlanID = recommendPlanID;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getRecommendPlanTitle() {
        return recommendPlanTitle;
    }

    public void setRecommendPlanTitle(String recommendPlanTitle) {
        this.recommendPlanTitle = recommendPlanTitle;
    }

    public String getRecommendPlanContent() {
        return recommendPlanContent;
    }

    public void setRecommendPlanContent(String recommendPlanContent) {
        this.recommendPlanContent = recommendPlanContent;
    }

    public LocalDate getRecommendPlanRemindTime() {
        return recommendPlanRemindTime;
    }

    public void setRecommendPlanRemindTime(LocalDate recommendPlanRemindTime) {
        this.recommendPlanRemindTime = recommendPlanRemindTime;
    }

    public boolean isRecommendPlanStatus() {
        return recommendPlanStatus;
    }

    public void setRecommendPlanStatus(boolean recommendPlanStatus) {
        this.recommendPlanStatus = recommendPlanStatus;
    }
}
