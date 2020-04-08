package com.pro.baby.repository;


import com.pro.baby.entity.FinalAppoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalAppointRepository extends JpaRepository<FinalAppoint ,Integer> {




}
