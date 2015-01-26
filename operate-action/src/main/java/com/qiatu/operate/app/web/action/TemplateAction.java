package com.qiatu.operate.app.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chechi on 15-1-13.
 */

@Controller
public class TemplateAction {

    @RequestMapping(value = "/template/{type}/{name}", method = RequestMethod.GET)
    public ModelAndView getTemplate(@PathVariable String type, @PathVariable String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("time_id", String.valueOf(System.currentTimeMillis()));
        modelAndView.setViewName(type + "_" + name);
        return modelAndView;
    }
}
