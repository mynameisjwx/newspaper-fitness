package com.hand6.health.app.service.impl;/**
 * Created by Administrator on 2019/7/3.
 */

import com.hand6.health.app.service.HandUserService;
import com.hand6.health.app.service.MotionIndicatorsService;
import com.hand6.health.domain.entity.HandUser;
import com.hand6.health.domain.entity.MotionIndicators;
import com.hand6.health.infra.mapper.MotionIndicatorsMapper;
import com.hand6.health.util.SysBeanUtil;
import io.choerodon.mybatis.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxxx
 * @description
 * @date 2019/7/3
 */
@Service
public class MotionIndicatorsServiceImpl extends BaseServiceImpl<MotionIndicators> implements MotionIndicatorsService {

    @Autowired
    private MotionIndicatorsMapper motionIndicatorsMapper;

    @Override
    public MotionIndicators save(MotionIndicators motionIndicators) {
        motionIndicatorsMapper.insert(motionIndicators);
        return motionIndicators;
    }

    @Override
    public List<MotionIndicators> list(MotionIndicators motionIndicators) {
        return motionIndicatorsMapper.select(motionIndicators);
    }

    @Override
    public MotionIndicators update(MotionIndicators motionIndicators) {
        MotionIndicators motionIndicatorsDB = motionIndicatorsMapper.selectByPrimaryKey(motionIndicators.getId());
        SysBeanUtil.copyPropertiesIgnoreNull(motionIndicators,motionIndicatorsDB);
        motionIndicatorsMapper.updateByPrimaryKey(motionIndicatorsDB);
        return motionIndicatorsDB;
    }

    @Override
    public MotionIndicators findById(Long id) {
        return motionIndicatorsMapper.selectByPrimaryKey(MotionIndicators.builder().id(id).build());
    }

    @Override
    public MotionIndicators deleteOne(MotionIndicators motionIndicators) {
        motionIndicatorsMapper.delete(motionIndicators);
        return motionIndicators;
    }

}
