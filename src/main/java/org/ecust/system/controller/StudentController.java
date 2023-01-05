package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.param.PageParam;
import org.ecust.system.pojo.vo.StudentVo;
import org.ecust.system.service.StudentService;
import org.ecust.system.service.impl.FaceServiceImpl;
import org.ecust.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("getAllStudent")
    @ApiOperation("分页查询所有学生")
    public Result getAllStudent(@RequestBody PageParam pageParam){
        List<StudentVo> list = studentService.getAllStudent(pageParam);
        return Result.success(list);
    }
    @PostMapping("add")
    @ApiOperation(value = "添加学生")
    public Result addStudent(){
        return null;
    }

    @GetMapping("test")
    @ApiOperation("test")
    public Result test(){
        return Result.success(FaceServiceImpl.faceMatch());
    }
}
