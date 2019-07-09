package com.hand6.demo.infra.mapper;

import com.hand6.demo.domain.entity.Task;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2019/7/3.
 */
public interface TaskMapper extends BaseMapper<Task> {
    Task selectByTaskNumber(@Param("taskNumber") String taskNumber);
}
