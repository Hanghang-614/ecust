package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.param.LoginParam;
import org.ecust.system.pojo.param.RegisterParam;
import org.ecust.system.service.UserService;
import org.ecust.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("login")
    @ApiOperation("登录接口，返回值没想好")
    public Result login(@RequestBody LoginParam loginParam){
        return userService.login(loginParam);
    }
    @PostMapping("register")
    @ApiOperation("注册,需要上传自己的一张照片")
    public Result register(@RequestParam("image") MultipartFile file,
                           @RequestParam("userNumber") Long userNumber,
                           @RequestParam("name") String name,
                           @RequestParam("password")String password,
                           @RequestParam("classId")Long classId,
                           @RequestParam("sex") String sex,
                           @RequestParam("roleId")Long roleId){
        RegisterParam registerParam = new RegisterParam();
        registerParam.setSex(sex);
        registerParam.setName(name);
        registerParam.setUserNumber(userNumber);
        registerParam.setPassword(password);
        registerParam.setClassId(classId);
        registerParam.setRoleId(roleId);
        return userService.register(file,registerParam);
    }
}
