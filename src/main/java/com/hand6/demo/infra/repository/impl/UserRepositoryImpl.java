package com.hand6.demo.infra.repository.impl;/**
 * Created by Administrator on 2019/7/3.
 */

import com.hand6.demo.infra.mapper.UserMapper;
import com.hand6.demo.domain.entity.User;
import com.hand6.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xxxx
 * @description
 * @date 2019/7/3
 */
@Component
public class UserRepositoryImpl implements UserRepository {
    private UserMapper userMapper;

    @Autowired
    public UserRepositoryImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User create(User user) {
        userMapper.insert(user);
        return user;
    }

}
