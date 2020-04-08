package com.pro.baby.service.index;


import com.pro.baby.entity.Article;
import com.pro.baby.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> showArticles() {
        return  articleRepository.findAll();
    }

}
