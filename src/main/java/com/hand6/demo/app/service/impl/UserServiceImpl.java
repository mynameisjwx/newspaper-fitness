package com.hand6.demo.app.service.impl;/**
 * Created by Administrator on 2019/7/3.
 */

import com.hand6.demo.app.service.UserService;
import com.hand6.demo.domain.entity.User;
import com.hand6.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xxxx
 * @description
 * @date 2019/7/3
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }
}
