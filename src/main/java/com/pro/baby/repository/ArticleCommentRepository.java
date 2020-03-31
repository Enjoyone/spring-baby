package com.pro.baby.repository;

import com.pro.baby.entity.Article;
import com.pro.baby.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleCommentRepository extends JpaRepository<ArticleComment,Integer> {

}
