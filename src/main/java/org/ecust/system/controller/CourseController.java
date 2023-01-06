package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.entity.Course;
import org.ecust.system.pojo.param.PageParam;
import org.ecust.system.pojo.vo.CourseVo;
import org.ecust.system.service.CourseService;
import org.ecust.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("getAllCourse")
    @ApiOperation(value ="分页查询课程信息")
    public Result getAllCourse(@RequestBody PageParam pageParam){
        List<CourseVo> list=courseService.getAllCourse(pageParam);
        return Result.success(list);
    }

    @PostMapping("findAll")
    @ApiOperation(value="查询课程信息")
    public List<CourseVo> findAll()
    {
        return courseService.findAll();
    }
    @PostMapping("findByName")
    @ApiOperation(value="根据id查询课程信息")
    public List<CourseVo> findById(Long id)
    {
        return courseService.findById(id);
    }
    @PostMapping("search")
    @ApiOperation(value="根据课程名称模糊查询课程信息")
    public List<CourseVo> search(String name)
    {
        return courseService.search(name);
    }
    @PostMapping("findTerm")
    @ApiOperation(value="根据开课学期查询课程信息")
    public List<CourseVo> findTerm(Long term)
    {
        return courseService.findTerm(term);
    }
    @PostMapping("addCourse")
    @ApiOperation(value="新增课程信息")
    public void addCourse(@RequestBody Course course)
    {
        courseService.addCourse(course);
    }
    @PostMapping("del")
    @ApiOperation(value="删除课程")
    public void del(@RequestBody Long id)
    {
        courseService.del(id);
    }
    @PostMapping("delAll")
    @ApiOperation(value="批量删除课程")
    public void delAll(@RequestBody Long[] ids)
    {
       courseService.delAll(ids);
    }
    @PostMapping("updateCourse")
    @ApiOperation(value="修改课程信息")
    public void updateCourse(@RequestBody Course course)
    {
        courseService.updateCourse(course);
    }
}
