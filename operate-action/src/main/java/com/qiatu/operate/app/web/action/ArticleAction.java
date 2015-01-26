package com.qiatu.operate.app.web.action;

import com.qiatu.operate.app.biz.ArticleService;
import com.qiatu.operate.app.common.Constant;
import com.qiatu.operate.app.common.PageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by chechi on 15-1-14.
 */

@Controller
public class ArticleAction extends BaseAction {

    private Logger logger = LoggerFactory.getLogger(ArticleAction.class);

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/article/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getArticleList() {

        PageModel pageModel = (PageModel) request.getAttribute("pageModel");

        Map<String, Object> data = articleService.getArticleList(pageModel);

        return data;
    }

    @RequestMapping(value = "/article/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addArticle(@RequestParam Map<String, String> articleData) {

        Map<String, Object> data = getResultDate();

        if (articleService.addArticle(articleData) > 0) {
            data.put(Constant.RESULT, Constant.RESULT_SUCCESS);
            return data;
        }

        data.put(Constant.RESULT, Constant.RESULT_FAIL);

        return data;
    }

    @RequestMapping(value = "/article/list/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getArticleById(@PathVariable int id) {

        Long aidLong = Long.valueOf(id);

        Map<String, String> article = articleService.getArticleById(aidLong);

        return article;
    }

    @RequestMapping(value = "/article/edit/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editArticleById(@PathVariable int id, @RequestParam Map<String, Object> article) {

        Map<String, Object> data = getResultDate();

        Long aidLong = Long.valueOf(id);

        article.put("id", aidLong);

        if (articleService.editArticleById(article) > 0) {
            data.put(Constant.RESULT, Constant.RESULT_SUCCESS);
            return data;
        }

        data.put(Constant.RESULT, Constant.RESULT_FAIL);

        return data;
    }

    @RequestMapping(value = "/article/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteArticleByIds(@RequestParam Long[] id) {

        Map<String, Object> data = getResultDate();

        if (articleService.deleteArticleByIds(id) > 0) {

            data.put(Constant.RESULT, Constant.RESULT_SUCCESS);

            return data;
        }

        data.put(Constant.RESULT, Constant.RESULT_FAIL);

        return data;

    }
}
