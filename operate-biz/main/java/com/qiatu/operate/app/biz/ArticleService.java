package com.qiatu.operate.app.biz;

import com.qiatu.operate.app.common.PageModel;

import java.util.List;
import java.util.Map;

/**
 * Created by chechi on 15-1-14.
 */
public interface ArticleService {
    Map<String, Object> getArticleList(PageModel pageModel);

    int addArticle(Map<String, String> articleData);

    Map<String, String> getArticleById(Long id);

    int editArticleById(Map<String,Object> article);

    int deleteArticleByIds(Long[] ids);
}
