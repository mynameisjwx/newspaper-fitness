package com.hand6.health.app.service;

import com.hand6.health.domain.entity.MotionIndicators;

import java.util.List;

/**
 * Created by Administrator on 2019/7/3.
 */
public interface MotionIndicatorsService {

    MotionIndicators save(MotionIndicators motionIndicators);

    List<MotionIndicators> list(MotionIndicators motionIndicators);

    MotionIndicators update(MotionIndicators motionIndicators);

    MotionIndicators findById(Long id);

    MotionIndicators deleteOne(MotionIndicators motionIndicators);
}
