package com.hand6.health.app.service;

import com.hand6.health.domain.entity.MotionIndicators;
import com.hand6.health.domain.entity.MotionRecords;

import java.util.List;

/**
 * Created by Administrator on 2019/7/3.
 */
public interface MotionRecordsService {

    MotionRecords save(MotionRecords motionRecords);

    MotionRecords update(MotionRecords motionRecords);

    MotionRecords remove(MotionRecords motionRecords);

    List<MotionRecords> list(MotionRecords motionRecords);
}
