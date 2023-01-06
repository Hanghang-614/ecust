package org.ecust.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ecust.system.mapper.CourseMapper;
import org.ecust.system.pojo.entity.Course;
import org.ecust.system.pojo.param.PageParam;
import org.ecust.system.pojo.vo.CourseVo;
import org.ecust.system.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
  @Autowired
    CourseMapper courseMapper;

  @Override
  public List<CourseVo> getAllCourseOrById(PageParam pageParam) {
      if(pageParam.getId()!=0)
      {
          return courseMapper.findById(pageParam.getId());
      }
      else {
          Page<Course> page = new Page<>(pageParam.getPage(), pageParam.getPageSize());
          Page<Course> coursePage = courseMapper.selectPage(page, new LambdaQueryWrapper<>());
          List<Course> records = coursePage.getRecords();
          List<CourseVo> courseVos = transform(records);
          return courseVos;
      }
  }
  private List<CourseVo> transform(List<Course> records)
  {
     List<CourseVo> courseVos=new ArrayList<CourseVo>();
     for(Course course:records)
     {
          CourseVo courseVo=new CourseVo();
          BeanUtils.copyProperties(course,courseVo);
          courseVos.add(courseVo);
     }
     return  courseVos;
  }
  @Override
  public List<CourseVo> findAll(){
    return courseMapper.findAll();
  }
  @Override
  public List<CourseVo> findById(Long id)
  {
    return courseMapper.findById(id);
  }
  @Override
  public List<CourseVo> search(String name)
  {
    return courseMapper.search(name);
  }
  @Override
  public List<CourseVo> findTerm(Long term)
  {
    return courseMapper.findTerm(term);
  }
  @Override
  public void addCourse(Course course)
  {
    courseMapper.addCourse(course);
  }
  @Override
  public void del(Long id)
  {
    courseMapper.del(id);
  }
  @Override
  public void delAll(Long[] ids)
  {
        for(Long id:ids)
        {
            courseMapper.del(id);
        }
  }
  @Override
  public void updateCourse(Course course)
  {
    courseMapper.updateCourse(course);
  }
}
