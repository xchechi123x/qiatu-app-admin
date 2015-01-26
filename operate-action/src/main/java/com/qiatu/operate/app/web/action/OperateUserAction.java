package com.qiatu.operate.app.web.action;

import com.qiatu.operate.app.biz.UserService;
import com.qiatu.operate.app.common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin.navig.motif.OJIPlugin;

import java.util.Map;

/**
 * Created by chechi on 15-1-21.
 */
@Controller
public class OperateUserAction extends BaseAction {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/admin/add/user", method = RequestMethod.GET)
    public Map<String, Object> addOperateUser(@RequestParam Map<String, String> map) {
        Map<String, Object> data = getResultDate();
        this.userService.addOperateUser(map);
        data.put(Constant.RESULT, Constant.RESULT_SUCCESS);
        return data;
    }
}
