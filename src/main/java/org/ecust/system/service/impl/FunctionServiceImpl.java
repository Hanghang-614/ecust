package org.ecust.system.service.impl;

import org.ecust.system.mapper.FunctionMapper;
import org.ecust.system.pojo.entity.Function;
import org.ecust.system.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {
    @Autowired
    private FunctionMapper functionMapper;
    @Override
    public List<Function> selectByParentId(Long parentId){
       return functionMapper.selectByParentId(parentId);
    }//根据父级id查询所有的权限功能
    @Override
    public List<Function> selectByRoleId(Long roleId){
        return functionMapper.selectByRoleId(roleId);
    }//查询指定角色所有的权限功能
    @Override
    public void deleteRoleFunction(Long roleId,Long functionId) {
        functionMapper.deleteRoleFunction(roleId,functionId);
    }
    @Override
    public void insertRoleFunction(Long roleId,Long functionId){
        functionMapper.InsertRoleFunction(roleId,functionId);
    }
}
