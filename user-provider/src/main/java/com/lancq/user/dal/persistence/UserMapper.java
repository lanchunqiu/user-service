package com.lancq.user.dal.persistence;

import com.lancq.user.dal.entity.User;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/1
 **/
public interface UserMapper {
    User getUserByUserName(String username);

    /**
     * 根据uid获取用户信息
     * @param uid
     * @return
     */
    User getUserByUid(Integer uid);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertSelective(User user);

}
