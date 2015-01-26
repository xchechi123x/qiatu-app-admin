package com.qiatu.operate.app.biz;

import com.qiatu.operate.app.common.PageModel;
import com.qiatu.operate.app.model.ImageModel;
import com.qiatu.operate.app.model.RecommendHotel;
import com.qiatu.operate.app.model.RecommendReasonArray;

import java.util.List;
import java.util.Map;

/**
 * Created by chechi on 15-1-16.
 */
public interface RecommendHotelService {
    Map<String,Object> getRecommendHotelList(PageModel pageModel);

    List<ImageModel> getReasonImages();

    void saveRecommendHotel(RecommendHotel hotel, RecommendReasonArray reasons);

    void deleteRecommendHotel(Long[] ids);

    RecommendHotel getRecommendHotelById(Long id);

    void updateRecommendHotel(RecommendHotel hotel, RecommendReasonArray reasons);
}
