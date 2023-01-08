package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.param.*;
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
    @PostMapping("getAllStudentOrTeacher")
    @ApiOperation("分页查询学生或者老师 roleId=0查询所有人")
    public Result getAllStudentOrTeacher(@RequestBody UserPageParam pageParam){
        return userService.getAllStudentOrTeacher(pageParam);
    }
    @GetMapping("getUserById")
    @ApiOperation("根据Id查询用户")
    public Result getUserById(@RequestParam("userId") Long userId){
        return userService.getUserById(userId);
    }

    @PostMapping("updateUser")
    @ApiOperation("更新用户基本信息")
    public Result updateUser(@RequestBody UpdateUserParam updateUserParam){
        return userService.updateUser(updateUserParam);
    }

    @GetMapping("deleteUser")
    @ApiOperation("删除用户")
    public Result deleteUser(@RequestParam("userId") Long userId){
        return userService.deleteUser(userId);
    }

    @PostMapping("addUser")
    @ApiOperation("添加用户")
    public Result addUser(@RequestBody RegisterParam registerParam){
        return userService.addUser(registerParam);
    }

    @PostMapping("upLoadPhoto")
    @ApiOperation("添加用户照片")
    public Result addUser(@RequestParam MultipartFile file,@RequestParam Long userId){
        return userService.upLoadPhoto(file,userId);
    }

    @GetMapping("getUserByUserNumber")
    @ApiOperation("根据userNumber查询user")
    public Result getUserByUserNumber(@RequestParam("userNumber") Long userNumber){
        return userService.getUserByUserNumber(userNumber);
    }

}
