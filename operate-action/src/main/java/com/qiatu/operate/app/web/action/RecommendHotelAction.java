package com.qiatu.operate.app.web.action;

import com.qiatu.operate.app.biz.RecommendHotelService;
import com.qiatu.operate.app.common.Constant;
import com.qiatu.operate.app.common.PageModel;
import com.qiatu.operate.app.model.ImageModel;
import com.qiatu.operate.app.model.RecommendHotel;
import com.qiatu.operate.app.model.RecommendReasonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by chechi on 15-1-16.
 */
@Controller
public class RecommendHotelAction extends BaseAction {

    @Autowired
    RecommendHotelService recommendHotelService;

    @RequestMapping(value = "/recommend/hotel/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getRecommendHostList() {

        PageModel pageModel = (PageModel) request.getAttribute("pageModel");

        Map<String, Object> data = recommendHotelService.getRecommendHotelList(pageModel);

        return data;
    }

    @RequestMapping(value = "/recommend/hotel/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addRecommendHotel(@ModelAttribute RecommendHotel hotel, @ModelAttribute RecommendReasonArray reasons) {

        Map<String, Object> data = getResultDate();
        this.recommendHotelService.saveRecommendHotel(hotel, reasons);
        data.put(Constant.RESULT, Constant.RESULT_SUCCESS);
        return data;
    }

    @RequestMapping(value = "/recommend/images/list", method = RequestMethod.GET)
    public ModelAndView listReasonImages() {

        List<ImageModel> reasonImageList = this.recommendHotelService.getReasonImages();

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("reasonImageList", reasonImageList);

        modelAndView.setViewName("reason_images");

        return modelAndView;
    }

    @RequestMapping(value = "/recommend/hotel/del", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteRecommendHotel(@RequestParam Long[] id) {

        Map<String, Object> data = getResultDate();
        this.recommendHotelService.deleteRecommendHotel(id);
        data.put(Constant.RESULT, Constant.RESULT_SUCCESS);
        return data;
    }

    @RequestMapping(value = "/recommend/hotel/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editRecommendHotelMessage(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();

        List<ImageModel> reasonImageList = this.recommendHotelService.getReasonImages();

        RecommendHotel recommendHotel = this.recommendHotelService.getRecommendHotelById(id);

        modelAndView.addObject("reasonImageList", reasonImageList);
        modelAndView.addObject("recommendHotel", recommendHotel);

        modelAndView.setViewName("recommend_edit");

        return modelAndView;
    }

    @RequestMapping(value = "/recommend/hotel/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateRecommendHotelMessage(@PathVariable Long id, @ModelAttribute RecommendHotel hotel, @ModelAttribute RecommendReasonArray reasons) {

        Map<String, Object> data = getResultDate();

        hotel.setId(id);

        this.recommendHotelService.updateRecommendHotel(hotel,reasons);
        data.put(Constant.RESULT, Constant.RESULT_SUCCESS);
        return data;
    }
}
