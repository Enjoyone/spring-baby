package com.pro.baby.repository;

import com.pro.baby.entity.Article;
import com.pro.baby.entity.Kid;
import com.pro.baby.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface KidRepository extends JpaRepository<Kid,Integer> {

    List<Kid> findAllByParent(Parent parent);
}
