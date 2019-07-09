package com.hand6.demo.api.controller.v1;/**
 * Created by Administrator on 2019/7/3.
 */

import com.hand6.demo.app.service.TaskService;
import com.hand6.demo.domain.entity.Task;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.util.Results;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author xxxx
 * @description
 * @date 2019/7/3
 */
@RestController
@RequestMapping(value = "/v1/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "创建task")
    public ResponseEntity<Task> create(@RequestBody Task task) {
        return Results.success(taskService.create(task));
    }

    @DeleteMapping("/{id}")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "根据id删除task")
    public void delete(@PathVariable Long id) {
        taskService.deleteById(id);
    }

    @DeleteMapping("/taskNumber/{taskNumber}")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "根据TaskNumber删除task")
    public void deleteByTaskNumber(@PathVariable String taskNumber) {
        taskService.deleteByTaskNumber(taskNumber);
    }

    @PutMapping("/{id}")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "更新task")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return Results.success(taskService.update(task));
    }

    @GetMapping("/{id}")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "查询task")
    public ResponseEntity<Task> query(@PathVariable Long id) {
        return Results.success(taskService.queryById(id));
    }

}
