package com.hand6.health.api.controller.v1;/**
 * Created by Administrator on 2019/7/6.
 */

import com.hand6.health.app.service.MotionRecordsService;
import com.hand6.health.domain.entity.MotionRecords;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xxxx
 * @description
 * @date 2019/7/6
 */
@RestController
@RequestMapping(value = "/v1/motionRecords")
public class MotionRecordsController {
    @Autowired
    private MotionRecordsService motionRecordsService;

    @PostMapping()
    @ApiOperation("新增跑步记录")
    public ResponseEntity<MotionRecords> add(@RequestBody MotionRecords motionRecords){
        return Results.success(motionRecordsService.save(motionRecords));
    }

    @PutMapping()
    @ApiOperation("更新跑步记录")
    public ResponseEntity<MotionRecords> update(@RequestBody MotionRecords motionRecords){
        return Results.success(motionRecordsService.update(motionRecords));
    }

    @DeleteMapping()
    @ApiOperation("删除跑步记录")
    public ResponseEntity<MotionRecords> remove(@RequestBody MotionRecords motionRecords){
        return Results.success(motionRecordsService.remove(motionRecords));
    }

    @GetMapping()
    @ApiOperation("查询跑步记录")
    public ResponseEntity<List<MotionRecords>> list(MotionRecords motionRecords){
        return Results.success(motionRecordsService.list(motionRecords));
    }

}
