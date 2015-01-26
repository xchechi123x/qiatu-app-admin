package com.qiatu.operate.app.web.intercept;

import com.qiatu.operate.app.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chechi on 15-1-12.
 */
public class LoginIntercepts extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(BaseParamsIntercept.class);

    @Autowired
    HttpSession httpSession;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (Constant.USER_LOGIN_SUCCESS.equals(httpSession.getAttribute("loginStatus"))) {
            return true;
        }
        response.sendRedirect("login.html");
        return false;
    }
}
