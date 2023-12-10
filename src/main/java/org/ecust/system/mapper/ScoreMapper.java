package org.ecust.system.mapper;


import org.apache.ibatis.annotations.Select;

public interface ScoreMapper {
    //获得某个学生选某门课程的数量来防止重复
   @Select("select count(*) from user_course where userId=#{userId} and courseId=#{courseId} and term=#{term}")
   Long check(Long userId,Long courseId,String term);
   //查看是否某学生的某门课程是否已经录入成绩
   @Select("select count(*) from user_course where userId=#{userId} and courseId=#{courseId} and term=#{term} and grade is null")
   Long checkNull(Long userId,Long courseId,String term);

}
