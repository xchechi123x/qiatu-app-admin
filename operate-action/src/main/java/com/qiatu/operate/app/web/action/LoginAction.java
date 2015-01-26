package com.qiatu.operate.app.web.action;

import com.qiatu.operate.app.biz.UserService;
import com.qiatu.operate.app.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by chechi on 15-1-12.
 */

@Controller
public class LoginAction extends BaseAction{

    Logger logger = LoggerFactory.getLogger(LoginAction.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam Map<String, String> map) {

        String userName = map.get("userName");
        String password = map.get("password");

        if (null == userName || "".equals(userName) || null == password || "".equals(password)) {
            return "redirect:/login.html";
        }

        if (userService.userLogin(map) > 0) {
            httpSession.setAttribute("loginStatus", Constant.USER_LOGIN_SUCCESS);
            return "redirect:/index";
        }

        return "redirect:/login.html";

    }
}
