package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.entity.User;
import org.ecust.system.service.UserService;
import org.ecust.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("login")
    @ApiOperation("登录接口，返回User基本信息")
    public User login(String studentId,String password){
        return userService.login(studentId,password);
    }
}
