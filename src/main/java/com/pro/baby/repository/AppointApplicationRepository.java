package com.pro.baby.repository;


import com.pro.baby.entity.AppointApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointApplicationRepository extends JpaRepository<AppointApplication,Integer> {



}
