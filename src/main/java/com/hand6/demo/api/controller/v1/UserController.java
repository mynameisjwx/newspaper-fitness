package com.hand6.demo.api.controller.v1;/**
 * Created by Administrator on 2019/7/3.
 */

import com.hand6.demo.app.service.UserService;
import com.hand6.demo.domain.entity.User;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.util.Results;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxxx
 * @description
 * @date 2019/7/3
 */
@RestController
@RequestMapping(value = "/v1/users1")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "创建todo 用户")
    private ResponseEntity<User> create(@RequestBody User user) {
        return Results.success(userService.create(user));
    }

}
