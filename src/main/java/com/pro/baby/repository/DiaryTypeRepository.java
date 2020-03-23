package com.pro.baby.repository;

import com.pro.baby.entity.Article;
import com.pro.baby.entity.DiaryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DiaryTypeRepository extends JpaRepository<DiaryType,Integer> {




    List<DiaryType> findByParent(int parentID);

    List<DiaryType> findAll();




}
