package org.ecust.system.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ecust.system.pojo.entity.Course;
import org.ecust.system.pojo.entity.UserCourse;
import org.ecust.system.pojo.vo.CourseVo;
import org.ecust.system.pojo.vo.GradeVo;
import org.ecust.system.pojo.vo.ScoreVo;


import java.util.List;

public interface CourseMapper {
    //学生查看课程
    @Select("select * from course")
    List<Course> selectAll();
    //实现学生选课
    @Insert("insert into user_course values(null,#{userId},#{courseId},#{term},null)")
    void selectCourse(Long userId,Long courseId,String term);

    //实现学生成绩的录入
    @Insert("insert into user_course(userId,courseId,term,grade) values(#{userId},#{courseId},#{term},#{grade})")
    void InsertScore(Long userId,Long courseId,String term,Long grade);
    //实现学生成绩的修正
    @Update("update user_course set grade=#{grade} where userId=#{userId} and courseId=#{courseId} and term=#{term}")
    void UpdateScore(Long userId,Long courseId,String term,Long grade);

    //学生分页查询某个学期的成绩
    @Select("select b.courseId,courseName,b.term,grade from course a,user_course b where a.courseId=b.courseId and userId=#{userId} and b.term=#{term} limit #{start},#{number}")
    List<ScoreVo> checkScore(Long userId,String term,Long start,Long number);

    //学生查询某个学期的成绩
    @Select("select c.userId,name,c.courseId,courseName,grade,c.term from user a,course b,user_course c where a.userId=c.userId and b.courseId=c.courseId" +
            " and studentId=#{studentId} and c.term=#{term}")
    List<GradeVo> checkScoreByterm(String studentId,String term);

    //计算学生某个学期所选的课程总数，需要控制在15-18之间
    @Select("select count(courseId) from user_course where userId=#{userId} and term=#{term}")
    Long calCourse(Long userId,String term);
    //学生可以分页查看所选的课程
    @Select("select * from course limit #{start},#{number}")
    List<Course> findCourseByPage(Long start,Long number);//start表示起始数据，number表示一页的数据容量
    //学生可以通过学号和学期查看本学期所选的课程
    @Select("select c.userId,name,c.courseId,courseName,c.term from user a,course b,user_course c where a.userId=c.userId and b.courseId=c.courseId " +
            "and c.term=#{term} and studentId=#{studentId}")
    List<CourseVo> findCourse(String studentId,String term);
    //根据学期查看开的课程
    @Select("select * from course where term=#{term}")
    List<Course> findCourseByterm(String term);

}
