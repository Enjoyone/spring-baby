package com.pro.baby.repository;


import com.pro.baby.entity.AppTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppTimeRepository extends JpaRepository<AppTime,Integer> {
}
