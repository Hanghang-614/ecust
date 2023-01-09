package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.entity.Function;
import org.ecust.system.pojo.entity.RoleFunction;
import org.ecust.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("Role")
public class RoleController {
    @Autowired
    RoleService roleService;
 @PostMapping("findAllFunction")
 @ApiOperation(value="根据parentId查询所有的权限功能")
    public List<Function> findAllFunction(Long parentId)
 {
     return  roleService.findAllFunction(parentId);
 }
 @PostMapping("findAllRoleFunction")
 @ApiOperation(value="查询指定角色所有的权限功能")
    public List<Function> findAllRoleFunction(Long roleId)
 {
     return roleService.findAllRoleFunction(roleId);
 }
 @PostMapping("deleteRoleFunction")
 @ApiOperation(value="删除某个角色权限功能")
 public void deleteRoleFunction(@RequestBody RoleFunction roleFunction)
 {
     roleService.deleteRoleFunction(roleFunction);
 }
    @PostMapping("insertRoleFunction")
    @ApiOperation(value="新增某个角色权限功能")
    public void insertRoleFunction(@RequestBody RoleFunction roleFunction)
    {
        roleService.insertRoleFunction(roleFunction);
    }
}
