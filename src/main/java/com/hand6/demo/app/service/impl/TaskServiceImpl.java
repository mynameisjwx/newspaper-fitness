package com.hand6.demo.app.service.impl;/**
 * Created by Administrator on 2019/7/3.
 */

import com.hand6.demo.app.service.TaskService;
import com.hand6.demo.domain.entity.Task;
import com.hand6.demo.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xxxx
 * @description
 * @date 2019/7/3
 */
@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task task) {
        return taskRepository.create(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void deleteByTaskNumber(String taskNumber) {
        taskRepository.deleteByTaskNumber(taskNumber);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.update(task);
    }

    @Override
    public Task queryById(Long id) {
        return taskRepository.queryById(id);
    }
}
