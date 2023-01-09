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
  @Delete("delete from role where id=#{id} and role_name=#{roleName}")
  void deleteRole(Role role);
  @Insert("insert into role values(#{id},#{roleName})")
  void insertRole(Role role);
}
