package com.pro.baby.repository;

import com.pro.baby.entity.Article;
import com.pro.baby.entity.Parent;
import com.pro.baby.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {

    List<Schedule> findAllByParent(Parent parent);
}
