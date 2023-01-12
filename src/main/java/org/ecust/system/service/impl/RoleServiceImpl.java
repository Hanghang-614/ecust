package org.ecust.system.service.impl;

import org.ecust.system.mapper.FunctionMapper;
import org.ecust.system.mapper.RoleMapper;
import org.ecust.system.pojo.entity.Function;
import org.ecust.system.pojo.entity.Role;
import org.ecust.system.pojo.entity.RoleFunction;
import org.ecust.system.pojo.param.FunctionParam;
import org.ecust.system.service.RoleService;
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
    public void deleteRoleFunction(RoleFunction roleFunction)
    {
        functionMapper.deleteRoleFunction(roleFunction);
    }
    @Override
    public void insertRoleFunction(RoleFunction roleFunction)
    {
        functionMapper.insertRoleFunction(roleFunction);
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
