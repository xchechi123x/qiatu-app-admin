package com.qiatu.operate.app.biz.impl;

import com.qiatu.operate.app.biz.ArticleService;
import com.qiatu.operate.app.common.PageModel;
import com.qiatu.operate.app.dao.mapper.ArticleMapper;
import com.qiatu.operate.app.model.ArticleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chechi on 15-1-14.
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Map<String, Object> getArticleList(PageModel pageModel) {

        Map<String, Object> data = new HashMap<String, Object>();

        List<ArticleModel> rows = articleMapper.getArticleList(pageModel.getRecordOffset(), pageModel.getPageSize());

        Integer total = articleMapper.getArticleListSize();

        data.put("total", total);
        data.put("rows", rows);

        return data;
    }

    @Override
    public int addArticle(Map<String, String> articleData) {
        return articleMapper.insertArticle(articleData);
    }

    @Override
    public Map<String, String> getArticleById(Long id) {
        return articleMapper.selectArticleById(id);
    }

    @Override
    public int editArticleById(Map<String, Object> article) {
        return articleMapper.updateArticleById(article);
    }

    @Override
    public int deleteArticleByIds(Long[] ids) {
        return articleMapper.deleteArticleByIds(ids);
    }
}
