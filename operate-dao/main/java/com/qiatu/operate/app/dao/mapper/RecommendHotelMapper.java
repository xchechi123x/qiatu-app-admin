package com.qiatu.operate.app.dao.mapper;

import com.qiatu.operate.app.model.ImageModel;
import com.qiatu.operate.app.model.RecommendHotel;
import com.qiatu.operate.app.model.RecommendReason;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chechi on 15-1-16.
 */

@Repository
@Transactional
public interface RecommendHotelMapper {

    List<RecommendHotel> selectRecommendHotelList(@Param("recordOffset") int recordOffset, @Param("pageSize") int pageSize);

    int getRecommendHotelSize();

    List<ImageModel> selectReasonImages(@Param("size") int size);

    Long saveRecommendHotel(RecommendHotel hotel);

    int saveRecommendHotelReason(RecommendReason reason);

    int deleteRecommendHotelById(@Param("ids") Long[] ids);

    int deleteRecommendReasonByHotelId(@Param("ids") Long[] ids);

    RecommendHotel selectRecommendHotelById(@Param("id") Long id);

    int updateRecommendHotel(RecommendHotel hotel);
}
