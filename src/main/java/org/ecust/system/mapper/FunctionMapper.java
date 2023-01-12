package org.ecust.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.ecust.system.pojo.entity.Function;
import org.ecust.system.pojo.entity.RoleFunction;
import org.ecust.system.pojo.param.FunctionParam;
import org.ecust.system.pojo.param.RoleFunctionParam;

import java.util.List;

public interface FunctionMapper extends BaseMapper<Function> {
    @Select("select * from function where parent_id=#{parentId}")
    List<Function> findAllFunction(Long parentId);
    @Select("select * from function where id in(select function_id from role_function where role_id=#{RoleId})")
    List<FunctionParam> findAllRoleFunction(Long RoleId);
    @Delete("delete from role_function where role_id=#{roleId} and function_id=#{functionId}")
    void deleteRoleFunction(RoleFunctionParam roleFunctionParam);
    @Insert("insert into role_function values(null,#{roleId},#{functionId})")
    void insertRoleFunction(RoleFunctionParam roleFunctionParam);
    @Delete("delete from role_function where role_id=#{roleId}")
    void deleteRoleFunctionByRoleId(Long roleId);
}
