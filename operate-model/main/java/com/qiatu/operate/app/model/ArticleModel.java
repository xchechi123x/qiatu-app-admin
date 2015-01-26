package com.qiatu.operate.app.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chechi on 15-1-14.
 */
public class ArticleModel implements Serializable {

    private Long id;

    private String title;

    private String subTitle;

    private String textBody;

    private int praiseCount;

    private Date updateTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }

    public String getUpdateTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        return format.format(updateTime);
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        return format.format(createTime);
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
