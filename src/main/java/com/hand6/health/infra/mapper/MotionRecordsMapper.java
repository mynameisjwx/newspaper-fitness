package com.hand6.health.infra.mapper;

import com.hand6.health.domain.entity.MotionRecords;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/7/6.
 */
public interface MotionRecordsMapper extends BaseMapper<MotionRecords> {
    List<MotionRecords> findAll(@Param("record") MotionRecords record);
}
