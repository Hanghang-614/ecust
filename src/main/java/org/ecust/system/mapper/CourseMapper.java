package org.ecust.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ecust.system.pojo.entity.Course;
import org.ecust.system.pojo.vo.CourseVo;
import java.util.List;

public interface CourseMapper extends BaseMapper<Course> {
    @Select("select * from course")
    List<CourseVo> findAll();

    @Select("select * from course where id=#{id}")
    List<CourseVo> findById(Long id);
    @Select("select * from course where name like concat('%',#{name},'%')")
    List<CourseVo> search(String name);

    @Select("select * from course where term=#{term}")
    List<CourseVo> findTerm(Long term);

    @Insert("insert into course values(#{id},#{courseNo},#{name},#{credit},#{term},#{teacherName})")
    void addCourse(Course course);

    @Delete("delete from course where id=#{id}")
    void del(Long id);

    @Update("update course set courseNo=#{courseNo},name=#{name},credit=#{credit},term=#{term},teacherName=#{teacherName} where id=#{id}")
    void updateCourse(Course course);

    @Select("select * from course where id in(select course_id from user_course where user_id in(select id from user where user_number=#{userNumber}))")
    List<CourseVo> findCourseByUserNumber(Long userNumber);
}
