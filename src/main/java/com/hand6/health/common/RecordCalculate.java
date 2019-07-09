package com.hand6.health.common;/**
 * Created by Administrator on 2019/7/6.
 */

import com.hand6.health.domain.entity.MotionRecords;
import com.hand6.health.infra.mapper.MotionIndicatorsMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xxxx
 * @description 单条记录判断逻辑
 * @date 2019/7/6
 */
public class RecordCalculate {
    @Autowired
    private MotionIndicatorsMapper motionIndicatorsMapper;

    public String CalculateRecord(MotionRecords motionRecords){

        return null;
    }
}
