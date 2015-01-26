package com.qiatu.operate.app.biz.impl;

import com.qiatu.operate.app.biz.RecommendHotelService;
import com.qiatu.operate.app.common.PageModel;
import com.qiatu.operate.app.dao.mapper.RecommendHotelMapper;
import com.qiatu.operate.app.model.ImageModel;
import com.qiatu.operate.app.model.RecommendHotel;
import com.qiatu.operate.app.model.RecommendReason;
import com.qiatu.operate.app.model.RecommendReasonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chechi on 15-1-16.
 */

@Service
public class RecommendHotelServiceImpl implements RecommendHotelService {

    @Autowired
    RecommendHotelMapper recommendHotelMapper;

    @Override
    public Map<String, Object> getRecommendHotelList(PageModel pageModel) {
        Map<String, Object> data = new HashMap<String, Object>();

        List<RecommendHotel> rows = recommendHotelMapper.selectRecommendHotelList(pageModel.getRecordOffset(), pageModel.getPageSize());

        Integer total = recommendHotelMapper.getRecommendHotelSize();

        data.put("total", total);

        data.put("rows", rows);

        return data;
    }

    @Override
    public List<ImageModel> getReasonImages() {
        List<ImageModel> reasonImageList = this.recommendHotelMapper.selectReasonImages(9);
        return reasonImageList;
    }

    @Override
    public void saveRecommendHotel(RecommendHotel hotel, RecommendReasonArray reasons) {
        this.recommendHotelMapper.saveRecommendHotel(hotel);
        Long hotelId = hotel.getId();
        for (int i = 0; i < reasons.getReason().length; i++) {
            RecommendReason reason = reasons.getReason()[i];
            reason.setRid(hotelId);
            this.recommendHotelMapper.saveRecommendHotelReason(reason);
        }
    }

    @Override
    public void deleteRecommendHotel(Long[] ids) {
        this.recommendHotelMapper.deleteRecommendHotelById(ids);
        this.recommendHotelMapper.deleteRecommendReasonByHotelId(ids);
    }

    @Override
    public RecommendHotel getRecommendHotelById(Long id) {
        return this.recommendHotelMapper.selectRecommendHotelById(id);
    }

    @Override
    public void updateRecommendHotel(RecommendHotel hotel, RecommendReasonArray reasons) {

        this.recommendHotelMapper.updateRecommendHotel(hotel);
        Long[] ids = new Long[1];
        ids[0] = hotel.getId();
        this.recommendHotelMapper.deleteRecommendReasonByHotelId(ids);

        for (int i = 0; i < reasons.getReason().length; i++) {
            reasons.getReason()[i].setRid(hotel.getId());
            this.recommendHotelMapper.saveRecommendHotelReason(reasons.getReason()[i]);
        }

    }


}
