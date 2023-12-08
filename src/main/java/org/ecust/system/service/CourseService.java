package org.ecust.system.service;

import org.ecust.system.pojo.entity.Course;
import org.ecust.system.pojo.entity.UserCourse;
import org.ecust.system.pojo.vo.CourseVo;
import org.ecust.system.pojo.vo.ScoreVo;

import java.util.List;

public interface CourseService {
    List<Course> selectAll();
    void selectCourse(Long userId,Long courseId,String term);
    void InputScore(Long userId,Long courseId,String term,Long grade);
    ScoreVo checkScore(Long userId,String term,Long start,Long number);
    boolean calCourse(Long userId,String term);
    List<Course> findCourseByPage(Long start,Long number);
    List<CourseVo> findCourse(String studentId,String term);

}
