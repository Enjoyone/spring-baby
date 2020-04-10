package com.pro.baby.repository;

import com.pro.baby.entity.Article;
import com.pro.baby.entity.Parent;
import com.pro.baby.entity.RecommendPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecommendPlanRepository extends JpaRepository<RecommendPlan,Integer> {

    List<RecommendPlan> findAllByParent(Parent parent);
}
