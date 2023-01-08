package org.ecust.system.service;

import org.ecust.system.pojo.entity.Course;
import org.ecust.system.pojo.param.PageParam;
import org.ecust.system.pojo.vo.CourseVo;
import java.util.List;

public interface CourseService {
    List<CourseVo> getAllCourseOrById(PageParam param);
    List<CourseVo> findAll();
    List<CourseVo> findById(Long id);
    List<CourseVo> search(String name);
    List<CourseVo> findTerm(Long term);
    void addCourse(Course course);
    void del(Long id);
    void delAll(Long[] ids);
    void updateCourse(Course course);
    List<CourseVo> findCourseByUserNumber(Long userNumber);
}
