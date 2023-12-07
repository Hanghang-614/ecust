package org.ecust.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ecust.system.pojo.entity.User;

public interface UserMapper extends BaseMapper<User>
{
   @Select("select * from user where studentId=#{studentId} and password=#{password}")
   public User login(String studentId,String password);
   @Insert("insert into user(userId,studentId,name,identificationId,password) values((select max(userId)+1 from user u),#{studentId},#{name},#{identificationId},#{password})")
   public void insertUser(String studentId,String name,String identificationId,String password);//注册用户
   @Update("update user set sex=#{sex},birthday=#{birthday},phone=#{phone},email=#{email} where studentId=#{studentId}")
   public void UpdateUser(String sex,String birthday,String phone,String email,String studentId);
}
