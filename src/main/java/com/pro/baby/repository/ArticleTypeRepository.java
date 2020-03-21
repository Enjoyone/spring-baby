package com.pro.baby.repository;

import com.pro.baby.entity.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleTypeRepository extends JpaRepository<ArticleType,Integer> {

}
