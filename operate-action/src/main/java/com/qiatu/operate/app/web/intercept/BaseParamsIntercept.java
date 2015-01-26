package com.qiatu.operate.app.web.intercept;

import com.qiatu.operate.app.common.PageModel;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by chechi on 15-1-14.
 */

public class BaseParamsIntercept extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        PageModel pageModel;

        if (null == request.getParameter("page") || null == request.getParameter("rows")) {

            pageModel = new PageModel(1, 15);

            request.setAttribute("pageModel", pageModel);

            return true;
        }

        if ("".equals(request.getParameter("page")) || "".equals(request.getParameter("rows"))) {
            return false;
        }

        Integer pageSize = Integer.valueOf(request.getParameter("rows"));

        Integer pageNo = Integer.valueOf(request.getParameter("page"));

        pageModel = new PageModel(pageNo, pageSize);

        request.setAttribute("pageModel", pageModel);

        return super.preHandle(request, response, handler);
    }
}
