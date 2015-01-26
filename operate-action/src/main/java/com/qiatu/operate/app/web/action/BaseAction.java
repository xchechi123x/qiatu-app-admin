package com.qiatu.operate.app.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by chechi on 15-1-14.
 */
@PropertySource(value = "classpath:application.properties")
public class BaseAction {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession httpSession;

    @Autowired
    Environment env;

    protected Map<String, Object> getResultDate() {
        Map<String, Object> data = new HashMap<String, Object>();
        return data;
    }

}
