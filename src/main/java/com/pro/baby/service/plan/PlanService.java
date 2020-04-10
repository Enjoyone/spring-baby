package com.pro.baby.service.plan;

import com.pro.baby.entity.Plan;
import com.pro.baby.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public  int addPlan(Plan plan){
        planRepository.save(plan);
        return plan.getPlanID();
    }

    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    public void deletePlanById(int planID) {
        planRepository.deleteById(planID);
    }
}
