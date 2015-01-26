package com.qiatu.operate.app.biz.impl;

import com.qiatu.operate.app.biz.UserService;
import com.qiatu.operate.app.common.AppUtils;
import com.qiatu.operate.app.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by chechi on 15-1-13.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int userLogin(Map<String, String> map) {
        String password = map.get("password");
        String secretPassword = AppUtils.sign(password);
        map.put("password", secretPassword);
        return userMapper.selectLoginUser(map);
    }

    @Override
    public void addOperateUser(Map<String, String> map) {
        String password = map.get("password");
        String secretPassword = AppUtils.sign(password);
        map.put("password", secretPassword);
        this.userMapper.addOperateUser(map);
    }
}
