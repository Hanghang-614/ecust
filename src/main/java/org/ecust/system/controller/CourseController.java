package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.entity.Course;

import org.ecust.system.pojo.entity.UserCourse;
import org.ecust.system.pojo.vo.CourseVo;
import org.ecust.system.pojo.vo.ScoreVo;
import org.ecust.system.service.CourseService;
import org.ecust.system.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private ScoreService scoreService;

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

    @PostMapping("selectManyCourses")
    @ApiOperation("学生批量选课")
    void selectManyCourses(@RequestBody List<UserCourse> userInfos){courseService.selectManyCourses(userInfos);}

    @PostMapping("InsertScore")
    @ApiOperation("录入学生的成绩")
    String InsertScore(Long userId,Long courseId,String term,Long grade){
        Long res=scoreService.check(userId, courseId,term);
        Long Nullres=scoreService.checkNull(userId, courseId,term);
        if(res==1 && Nullres==1) {
            courseService.InsertScore(userId, courseId, term, grade);
            return "成绩录入成功!";
        }
        else if(res==1 && Nullres==0){
            return "该门课成绩已经被录入!";
        }
        else{
            return "该生本学期未选择这门课程!";
        }
    }

    @PostMapping("UpdateScore")
    @ApiOperation("修改学生的成绩")
    String UpdateScore(Long userId,Long courseId,String term,Long grade)
    {
        Long res=scoreService.check(userId, courseId,term);
        Long Nullres=scoreService.checkNull(userId, courseId,term);
        if(res==1 && Nullres==0) {
            courseService.InsertScore(userId, courseId, term, grade);
            return "成绩修改成功!";
        }
        else if(res==1 && Nullres==1){
           return "成绩尚未被录入,无法进行修改!";
        }
        else{
            return "该生本学期未选择这门课程!";
        }
    }

    @PostMapping("checkScore")
    @ApiOperation("学生分页查询某个学期的学习成绩")
    List<ScoreVo> checkScore(Long userId,String term,Long start,Long number){return courseService.checkScore(userId,term,start,number);}

//    @PostMapping("checkScoreByterm")
//    @ApiOperation("学生查询某个学期的学习成绩")
//    List<GradeVo> checkScoreByterm(String studentId, String term){return courseService.checkScoreByterm(studentId, term);}

    @PostMapping("calCourse")
    @ApiOperation("判断学生某学期选课数量是否处于正常范围5-14")
    boolean calCourse(Long userId,String term){return courseService.calCourse(userId,term);}

    @PostMapping("findCourseByPage")
    @ApiOperation("学生分页查询课程")
    List<Course> findCourseByPage(Long start,Long number){return courseService.findCourseByPage(start,number);}

    @PostMapping("findCourse")
    @ApiOperation("学生根据学号和学期查看个人所选课程")
    List<CourseVo> findCourse(String studentId,String term){return courseService.findCourse(studentId,term);}

    @PostMapping("findCourseByterm")
    @ApiOperation("根据学期查看开设的课程")
    List<Course> findCourseByterm(String term){return courseService.findCourseByterm(term); }
}
