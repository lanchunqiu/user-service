package com.lancq.user.dal.persistence;

import com.lancq.user.dal.entity.User;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/1
 **/
public interface UserMapper {
    User getUserByUserName(String username);
}
