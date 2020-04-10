package com.pro.baby.repository;

import com.pro.baby.entity.Appoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointRepository extends JpaRepository<Appoint, Integer> {




    @Query("select a from Appoint a where a.parent.parentID=?1")
    List<Appoint> backByParentID(int ParentID);



}
