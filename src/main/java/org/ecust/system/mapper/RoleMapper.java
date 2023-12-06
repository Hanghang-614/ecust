package org.ecust.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.ecust.system.pojo.entity.Role;
import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
  @Select("select * from role")
  List<Role> findAllRole();
  @Delete("delete from role where roleId=#{roleId} and roleName=#{roleName}")
  void deleteRole(Role role);
  @Insert("insert into role values(#{roleId},#{roleName})")
  void insertRole(Role role);
  @Select("select roleName from role where roleId=(select roleId from user where studentId=#{studentId})")
  String selectBystudentId(String studentId);
}
