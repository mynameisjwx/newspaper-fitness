package com.hand6.health.app.service;

import com.hand6.health.domain.entity.HandUser;

import java.util.List;

/**
 * Created by Administrator on 2019/7/3.
 */
public interface HandUserService {

    HandUser save(HandUser handUser);

    List<HandUser> list(HandUser handUser);

    HandUser findById(Long id);

    HandUser update(HandUser handUser);
}
