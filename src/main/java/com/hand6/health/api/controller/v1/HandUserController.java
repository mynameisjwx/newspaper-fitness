package com.hand6.health.api.controller.v1;/**
 * Created by Administrator on 2019/7/3.
 */

import com.hand6.health.app.service.HandUserService;
import com.hand6.health.app.service.impl.HandUserServiceImpl;
import com.hand6.health.domain.entity.HandUser;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

/**
 * @author xxxx
 * @description
 * @date 2019/7/3
 */
@RestController
@RequestMapping(value = "/v1/users")
public class HandUserController {

    @Autowired
    private HandUserService handuserService;

    @PostMapping()
    @ApiOperation(value = "创建hand用户")
    public ResponseEntity<HandUser> save(@RequestBody HandUser handUser) {

        return Results.success(handuserService.save(handUser));

    }

    @GetMapping()
    @ApiOperation(value = "查询hand用户")
    public ResponseEntity<List<HandUser>> list(HandUser handUser) {
        return Results.success(handuserService.list(handUser));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询hand用户")
    public ResponseEntity<HandUser> list(@PathVariable Long id) {
        return Results.success(handuserService.findById(id));
    }

    @PutMapping()
    @ApiOperation("更新用户信息")
    public ResponseEntity<HandUser> update(@RequestBody HandUser handUser){
        return Results.success(handuserService.update(handUser));
    }


}
