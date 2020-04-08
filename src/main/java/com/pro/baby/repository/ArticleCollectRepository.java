package com.pro.baby.repository;

import com.pro.baby.entity.ArticleCollect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleCollectRepository extends JpaRepository<ArticleCollect,Integer> {
}
