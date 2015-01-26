package com.qiatu.operate.app.model;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chechi on 15-1-16.
 */
public class RecommendHotel implements Serializable {

    private Long id;

    private String hotelName;

    private String recommendTitle;

    private Date recommendTime;

    private Date updateTime;

    private Date createTime;

    private List<RecommendReason> reasons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRecommendTitle() {
        return recommendTitle;
    }

    public void setRecommendTitle(String recommendTitle) {
        this.recommendTitle = recommendTitle;
    }

    public String getRecommendTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        return format.format(this.recommendTime);

    }

    public void setRecommendTime(String dateTimeString) {
        String dateTime = dateTimeString;
        Date time = null;
        try {
            time = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
            this.recommendTime = new Date();
        }
        this.recommendTime = time;

    }

    public String getUpdateTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        return format.format(this.updateTime);

    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        return format.format(this.updateTime);
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<RecommendReason> getReasons() {
        return reasons;
    }

    public void setReasons(List<RecommendReason> reasons) {
        this.reasons = reasons;
    }
}
