package org.ecust.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.ecust.system.pojo.entity.User;

public interface UserMapper extends BaseMapper<User>
{
   @Select("select * from user where studentId=#{studentId} and password=#{password}")
   public User login(String studentId,String password);
}
