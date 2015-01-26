package com.qiatu.operate.app.dao.mapper;

import com.qiatu.operate.app.model.ArticleModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by chechi on 15-1-14.
 */

@Repository
public interface ArticleMapper {

    List<ArticleModel> getArticleList(@Param("recordOffset") int recordOffset, @Param("pageSize") int pageSize);

    Map<String, String> selectArticleById(@Param("id") Long id);

    int getArticleListSize();

    int insertArticle(Map<String, String> articleData);

    int updateArticleById(Map<String, Object> article);

    int deleteArticleByIds(@Param("ids")Long[] ids);
}
