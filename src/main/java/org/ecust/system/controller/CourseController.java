package org.ecust.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.entity.Course;
import org.ecust.system.pojo.entity.UserCourse;
import org.ecust.system.pojo.vo.ScoreVo;
import org.ecust.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("findAllCourse")
    @ApiOperation("查询所有课程信息")
    List<Course> selectAll() {
        return courseService.selectAll();
    }

    @PostMapping("selectCourse")
    @ApiOperation("学生进行选课")
    void selectCourse(Long userId, Long courseId, String term) {
        courseService.selectCourse(userId, courseId, term);
    }

    @PostMapping("InputScore")
    @ApiOperation("录入学生的成绩")
    void InputScore(Long userId,Long courseId,String term,Long grade){courseService.InputScore(userId,courseId,term,grade);}

    @PostMapping("checkScore")
    @ApiOperation("学生分页查询某个学期的学习成绩")
    ScoreVo checkScore(Long userId,String term,Long start,Long number){return courseService.checkScore(userId,term,start,number);}

    @PostMapping("calCourse")
    @ApiOperation("判断学生某学期选课数量是否处于正常范围15-18")
    boolean calCourse(Long userId,String term){return courseService.calCourse(userId,term);}

    @PostMapping("findCourseByPage")
    @ApiOperation("学生分页查询课程")
    List<Course> findCourseByPage(Long start,Long number){return courseService.findCourseByPage(start,number);}
}
