package com.qiatu.operate.app.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chechi on 15-1-12.
 */

@Controller
public class IndexAction {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
