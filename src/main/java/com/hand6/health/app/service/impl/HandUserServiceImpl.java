package com.hand6.health.app.service.impl;/**
 * Created by Administrator on 2019/7/3.
 */

import com.hand6.health.app.service.HandUserService;
import com.hand6.health.domain.entity.HandUser;
import com.hand6.health.infra.mapper.HandUserMapper;
import com.hand6.health.util.MD5Util;
import com.hand6.health.util.SysBeanUtil;
import io.choerodon.mybatis.service.BaseServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxxx
 * @description
 * @date 2019/7/3
 */
@Service
public class HandUserServiceImpl extends BaseServiceImpl<HandUser> implements HandUserService {

    @Autowired
    private HandUserMapper handUserMapper;
    @Override
    public HandUser save(HandUser handUser) {
        handUser.setPassword(MD5Util.md5(handUser.getPassword()));
        handUserMapper.insert(handUser);
         return handUser;
    }

    @Override
    public List<HandUser> list(HandUser handUser) {
       List<HandUser> list =  handUserMapper.select(handUser);
       return list;
    }

    @Override
    public HandUser findById(Long id) {
        HandUser handUser=handUserMapper.selectOne(HandUser.builder().id(id).build());
        return handUser;
    }

    @Override
    public HandUser update(HandUser handUser) {
        HandUser handUser1 = handUserMapper.selectByPrimaryKey(handUser.getId());
        SysBeanUtil.copyPropertiesIgnoreNull(handUser,handUser1);
        handUserMapper.updateByPrimaryKeySelective(handUser1);
        return handUser1;
    }
}
