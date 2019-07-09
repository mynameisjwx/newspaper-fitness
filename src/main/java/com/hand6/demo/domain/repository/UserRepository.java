package com.hand6.demo.domain.repository;/**
 * Created by Administrator on 2019/7/3.
 */

import com.hand6.demo.domain.entity.User;

/**
 * @author xxxx
 * @description
 * @date 2019/7/3
 */
public interface  UserRepository {
    User create(User user);
}
