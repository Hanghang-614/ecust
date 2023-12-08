package org.ecust.system.service.impl;

import org.ecust.system.mapper.CourseMapper;
import org.ecust.system.pojo.entity.Course;
import org.ecust.system.pojo.entity.UserCourse;
import org.ecust.system.pojo.vo.CourseVo;
import org.ecust.system.pojo.vo.ScoreVo;
import org.ecust.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Override
    public List<Course> selectAll(){
        return courseMapper.selectAll();
    }
    @Override
    public void selectCourse(Long userId,Long courseId,String term){
        courseMapper.selectCourse(userId,courseId,term);
    }
    @Override
    public void selectManyCourses(List<UserCourse> userInfos)
    {
        for(UserCourse entity:userInfos)
        {
            courseMapper.selectCourse(entity.getUserId(),entity.getCourseId(),entity.getTerm());
        }
    }
    @Override
    public void InsertScore(Long userId,Long courseId,String term,Long grade){ courseMapper.InsertScore(userId,courseId,term,grade);}
    @Override
    public void UpdateScore(Long userId,Long courseId,String term,Long grade){courseMapper.UpdateScore(userId, courseId, term, grade);}
//    @Override
//    public List<GradeVo> checkScoreByterm(String studentId,String term){return courseMapper.checkScoreByterm(studentId, term); }
    @Override
    public List<ScoreVo> checkScore(Long userId,String term,Long start,Long number){return courseMapper.checkScore(userId,term,start,number); }
    @Override
    public boolean calCourse(Long userId,String term)
    {
        Long res=courseMapper.calCourse(userId,term);
        if(res>=15 && res<=18) return true;
        else return false;
    }
    @Override
    public List<Course> findCourseByPage(Long start,Long number){
        return courseMapper.findCourseByPage(start,number);
    }
    @Override
    public List<CourseVo> findCourse(String studentId,String term){ return courseMapper.findCourse(studentId,term);}
    @Override
    public List<Course> findCourseByterm(String term){return courseMapper.findCourseByterm(term); }
}
