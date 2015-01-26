package com.qiatu.operate.app.biz;

import java.util.Map;

/**
 * Created by chechi on 15-1-13.
 */
public interface UserService {

    public int userLogin(Map<String,String> map);

    void addOperateUser(Map<String, String> map);
}
