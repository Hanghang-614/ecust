package org.ecust.system.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.ecust.system.pojo.entity.Function;

import java.util.List;

public interface FunctionMapper
{
    @Select("select * from function_copy1 where parentId=#{parentId}")//根据parentId查询所有的功能,0表示顶端功能
    List<Function> selectByParentId(Long parentId);
    @Select("select * from function_copy1 where functionId in(select functionId from role_function where roleId=#{roleId})")//查询指定角色对应所有的角色功能
    List<Function> selectByRoleId(Long roleId);
    @Delete("delete from role_function where roleId=#{roleId} and functionId=#{functionId}")
    void deleteRoleFunction(Long roleId,Long functionId);
    @Insert("insert into role_function(id,roleId,functionId) values((select max(id)+1 from role_function u),#{roleId},#{functionId})")
    void InsertRoleFunction(Long roleId,Long functionId);
}
