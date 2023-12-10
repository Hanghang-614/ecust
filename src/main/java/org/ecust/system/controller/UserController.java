package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.entity.User;
import org.ecust.system.service.UserService;
import org.ecust.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("register")
    @ApiOperation("注册接口")
    public void register(String studentId,String name,String identificationId,String password){ userService.InsertUser(studentId,name,identificationId,password);}
    @PostMapping("UpdateUser")
    @ApiOperation("更新用户信息")
    public void UpdateUser(String sex,String birthday,String phone,String email,String studentId){ userService.UpdateUser(sex,birthday,phone,email,studentId);}
    @PostMapping("Keepalive")
    @ApiOperation("激活用户")
    public void Keepalive(String studentId){userService.Keepalive(studentId);};
    @PostMapping("cancel")
    @ApiOperation("注销用户")
    public void cancel(String studentId){userService.cancel(studentId);}
    @PostMapping("showAllusers")
    @ApiOperation("展示所有学生的信息")
    public List<User> showAllUsers(){return userService.showAllusers();}

}
