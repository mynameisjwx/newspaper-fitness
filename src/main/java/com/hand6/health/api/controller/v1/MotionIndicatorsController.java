package com.hand6.health.api.controller.v1;/**
 * Created by Administrator on 2019/7/5.
 */

import com.hand6.health.app.service.MotionIndicatorsService;
import com.hand6.health.domain.entity.MotionIndicators;
import com.hand6.health.infra.mapper.MotionIndicatorsMapper;
import io.choerodon.core.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

/**
 * @author xxxx
 * @description
 * @date 2019/7/5
 */
@RestController
@RequestMapping("/v1/motionIndicators")
public class MotionIndicatorsController {

    @Autowired
    private MotionIndicatorsService motionIndicatorsService;

    @PostMapping()
    @ApiOperation("新增运动指标")
    public ResponseEntity<MotionIndicators> add(@RequestBody MotionIndicators motionIndicators){
        return Results.success(motionIndicatorsService.save(motionIndicators));
    }

    @GetMapping()
    @ApiOperation("获取指标列表")
    public ResponseEntity<List<MotionIndicators>> list(MotionIndicators motionIndicators){
        return Results.success(motionIndicatorsService.list(motionIndicators));
    }

    @GetMapping("/{id}")
    @ApiOperation("获取指标列表")
    public ResponseEntity<MotionIndicators> findById(@PathVariable Long id){
        return Results.success(motionIndicatorsService.findById(id));
    }

    @PutMapping()
    @ApiOperation("更新指标")
    public ResponseEntity<MotionIndicators> update(@RequestBody MotionIndicators motionIndicators){
        return Results.success(motionIndicatorsService.update(motionIndicators));
    }

    @DeleteMapping()
    @ApiOperation("删除指标")
    public ResponseEntity<MotionIndicators> delete(@RequestBody MotionIndicators motionIndicators){
        return Results.success(motionIndicatorsService.deleteOne(motionIndicators));
    }
}

