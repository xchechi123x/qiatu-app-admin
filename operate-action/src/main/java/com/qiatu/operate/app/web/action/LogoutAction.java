package com.qiatu.operate.app.web.action;

import com.qiatu.operate.app.biz.UserService;
import com.qiatu.operate.app.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by chechi on 15-1-21.
 */
public class LogoutAction extends BaseAction {

    Logger logger = LoggerFactory.getLogger(LoginAction.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String login(@RequestParam Map<String, String> map) {

        httpSession.removeAttribute("loginStatus");

        return "redirect:/login.html";

    }
}
