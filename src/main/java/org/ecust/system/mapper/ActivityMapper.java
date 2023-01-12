package org.ecust.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ecust.system.pojo.entity.Activity;
import org.ecust.system.pojo.entity.User;
import org.ecust.system.pojo.param.ActivityParam;

import java.util.Date;
import java.util.List;

public interface ActivityMapper extends BaseMapper<Activity> {

    @Select("select id from activity where id=#{id}")
    Long findId(Long id);
    @Select("select begin_time from activity where id=#{id}")
    Date findBegin(Long id);
    @Select("select end_time from activity where id=#{id}")
    Date findEnd(Long id);
    @Select("select * from activity where id=#{id}")
    List<Activity> findActivityById(Long id);
    @Insert("insert into activity values(#{id},#{beginTime},#{endTime},#{courseNo})")
    void addActivity(ActivityParam activityParam);
    @Delete("delete from activity where id=#{id}")
    void deleteActivity(Long id);
    @Update("update activity set end_time=now() where id=#{id}")
    void endActivity(Long id);
    @Select("select * from user where user_number in(select user_number from sign where isCheck=1 and time>(select begin_time from activity where id=#{id}) and time<(select end_time from activity where id=#{id}))")
    List<User> selectWhoJoin(Long id);
}
