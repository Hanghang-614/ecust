package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
    @PostMapping("add")
    @ApiOperation(value = "添加学生")
    public Result addStudent(){
        return null;
    }
}
