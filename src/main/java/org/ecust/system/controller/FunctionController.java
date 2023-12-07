package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.entity.Function;
import org.ecust.system.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("function")
public class FunctionController
{
    @Autowired
    private FunctionService functionService;
    @PostMapping("selectByParentId")
    @ApiOperation("根据parentId查询所有的权限功能")
    List<Function> selectByParentId(Long parentId){return functionService.selectByParentId(parentId);}
    @PostMapping("selectByRoleId")
    @ApiOperation("查询指定角色（学生/管理员）对应所有的权限功能")
    List<Function> selectByRoleId(Long roleId){return functionService.selectByRoleId(roleId);}
    @PostMapping("deleteRoleFunction")
    @ApiOperation("删除某个角色功能关联")
    void deleteRoleFunction(Long roleId,Long functionId){functionService.deleteRoleFunction(roleId,functionId);}
    @PostMapping("insertRoleFunction")
    @ApiOperation("新增某个角色功能关联")
    void insertRoleFunction(Long roleId,Long functionId){functionService.insertRoleFunction(roleId,functionId);}

}
