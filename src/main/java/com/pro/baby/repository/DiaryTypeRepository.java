package com.pro.baby.repository;

import com.pro.baby.entity.DiaryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DiaryTypeRepository extends JpaRepository<DiaryType,Integer> {



    @Query("select a from DiaryType a where a.parent.parentID=?1")
    List<DiaryType> findByParent(int parentID);


    List<DiaryType> findAll();



}
