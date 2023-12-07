package org.ecust.system.service.impl;

import org.ecust.system.mapper.RoleMapper;
import org.ecust.system.pojo.entity.Role;
import org.ecust.system.service.RoleService;
import org.ecust.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleMapper roleMapper;

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
    public void insertRole(Role role)
    {
        roleMapper.insertRole(role);
    }
    @Override
    public String selectBystudentId(String studentId){return roleMapper.selectBystudentId(studentId);}
    @Override
    public void allocRole(String studentId,Long roleId){ roleMapper.allocRole(studentId,roleId);}
}
