package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.param.AddUserCourseParam;
import org.ecust.system.pojo.param.DeleteUserCourseParam;
import org.ecust.system.service.UserCourseService;
import org.ecust.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userCourse")
public class UserCourseController {
    @Autowired
    UserCourseService userCourseService;
    @ApiOperation("根据学生学号，查看该学生已选课程")
    @GetMapping("getUserCourse")
    public Result getUserCourse(@RequestParam("userNumber") Long userNumber){
        return userCourseService.getUserCourse(userNumber);
    }

    @ApiOperation("查看课程的学生")
    @GetMapping("getCourseUser")
    public Result getCourseUser(@RequestParam("courseNo") Long courseNo){
        return userCourseService.getCourseUser(courseNo);
    }

    @ApiOperation("学生选课(单选添加)，传的都是ID")
    @PostMapping("addUserCourse")
    public Result addCourse(@RequestBody AddUserCourseParam addUserCourseParam){
        return userCourseService.addUserCourse(addUserCourseParam);
    }
    @ApiOperation("学生退课(单选退课),传的都是ID")
    @PostMapping("deleteUserCourse")
    public Result deleteUserCourse(@RequestBody DeleteUserCourseParam deleteUserCourseParam){
        return userCourseService.deleteUserCourse(deleteUserCourseParam);
    }


}
