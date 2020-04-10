package com.pro.baby.service.schedule;

import com.pro.baby.entity.Parent;
import com.pro.baby.entity.RecommendPlan;
import com.pro.baby.repository.RecommendPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendService {

    @Autowired
    RecommendPlanRepository recommendPlanRepository;

    public List<RecommendPlan> findAllbyParent(Parent parent) {
            return recommendPlanRepository.findAllByParent(parent);


    }

    public void addPlan(RecommendPlan r) {
        recommendPlanRepository.save(r);
    }
}
