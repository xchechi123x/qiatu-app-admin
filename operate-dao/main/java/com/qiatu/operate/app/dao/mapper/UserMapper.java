package com.qiatu.operate.app.dao.mapper;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by chechi on 15-1-21.
 */

@Repository
public interface UserMapper {
    int selectLoginUser(Map<String, String> map);

    int addOperateUser(Map<String, String> map);
}
