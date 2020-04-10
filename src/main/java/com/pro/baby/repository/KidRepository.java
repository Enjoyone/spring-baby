package com.pro.baby.repository;

import com.pro.baby.entity.Article;
import com.pro.baby.entity.Kid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface KidRepository extends JpaRepository<Kid,Integer> {


    @Query("select a from Kid a where a.parent.parentID=?1")
    List<Kid> backKidOfParent(int parentID);

}
