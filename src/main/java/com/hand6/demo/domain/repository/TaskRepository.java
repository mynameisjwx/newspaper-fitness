package com.hand6.demo.domain.repository;

import com.hand6.demo.domain.entity.Task;

/**
 * Created by Administrator on 2019/7/3.
 */
public interface TaskRepository {
    Task create(Task task);

    void deleteById(Long id);

    void deleteByTaskNumber(String taskNumber);

    Task update(Task task);

    Task queryById(Long id);
}
