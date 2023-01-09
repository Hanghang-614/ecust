package org.ecust.system.service.impl;

import org.ecust.system.mapper.FunctionMapper;
import org.ecust.system.mapper.RoleMapper;
import org.ecust.system.pojo.entity.Function;
import org.ecust.system.pojo.entity.RoleFunction;
import org.ecust.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    FunctionMapper functionMapper;
    @Override
    public List<Function> findAllFunction(Long parentId)
    {
      return functionMapper.findAllFunction(parentId);
    }
    @Override
    public List<Function> findAllRoleFunction(Long roleId)
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
}
