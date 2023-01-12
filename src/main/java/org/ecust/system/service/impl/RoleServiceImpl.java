package org.ecust.system.service.impl;

import org.ecust.system.mapper.FunctionMapper;
import org.ecust.system.mapper.RoleMapper;
import org.ecust.system.pojo.entity.Function;
import org.ecust.system.pojo.entity.Role;
import org.ecust.system.pojo.entity.RoleFunction;
import org.ecust.system.pojo.param.FunctionParam;
import org.ecust.system.pojo.param.RoleFunctionParam;
import org.ecust.system.service.RoleService;
import org.ecust.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    FunctionMapper functionMapper;
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<Function> findAllFunction(Long parentId)
    {
      return functionMapper.findAllFunction(parentId);
    }
    @Override
    public List<FunctionParam> findAllRoleFunction(Long roleId)
    {
        return functionMapper.findAllRoleFunction(roleId);
    }
    @Override
    public Result deleteRoleFunction(RoleFunctionParam roleFunctionParam)
    {
        List<FunctionParam> list=functionMapper.findAllRoleFunction(roleFunctionParam.getRoleId());
        for(int i=0;i<list.size();i++)
        {
            if(roleFunctionParam.getFunctionId()==list.get(i).getId())
            {
                functionMapper.deleteRoleFunction(roleFunctionParam);
                return Result.success("删除成功");
            }
        }
        return Result.fail(666,"删除失败，不存在这种角色功能关联");
    }
    @Override
    public Result insertRoleFunction(RoleFunctionParam roleFunctionParam)
    {
        List<FunctionParam> list=functionMapper.findAllRoleFunction(roleFunctionParam.getRoleId());
        for(int i=0;i<list.size();i++)
        {
            if(roleFunctionParam.getFunctionId()==list.get(i).getId())
            {
                return Result.fail(666,"插入失败,已经存在这样的角色功能关联");
            }
        }
        functionMapper.insertRoleFunction(roleFunctionParam);
        return Result.success("插入成功");
    }
    @Override
    public List<Role> findAllRole()
    {
        return roleMapper.findAllRole();
    }
    @Override
    public void deleteRole(Role role)
    {
        roleMapper.deleteRole(role);
    }
    @Override
    public void deleteRoleFunctionByRoleId(Long roleId)
    {
        functionMapper.deleteRoleFunctionByRoleId(roleId);
    }
    @Override
    public void insertRole(Role role)
    {
        roleMapper.insertRole(role);
    }
}
