package com.qiatu.operate.app.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chechi on 15-1-16.
 */
public class RecommendReason implements Serializable {

    private Long id;

    private Long rid;

    private Long imgId;

    private String title;

    private String describe;

    private Date updateTime;

    private Date createTime;

    public RecommendReason() {
    }

    public RecommendReason(Long id, Long imgId, String title, String describe) {
        this.id = id;
        this.imgId = imgId;
        this.title = title;
        this.describe = describe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImgId() {
        return imgId;
    }

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}

