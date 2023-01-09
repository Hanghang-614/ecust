package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.entity.Function;
import org.ecust.system.pojo.entity.Role;
import org.ecust.system.pojo.entity.RoleFunction;
import org.ecust.system.service.RoleService;
import org.ecust.system.utils.Result;
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
    public Result findAllFunction(Long parentId)
 {
     List<Function> list=roleService.findAllFunction(parentId);
     return Result.success(list);
 }
 @PostMapping("findAllRoleFunction")
 @ApiOperation(value="查询指定角色所有的权限功能")
    public Result findAllRoleFunction(Long roleId)
 {
     List<Function> list=roleService.findAllRoleFunction(roleId);
     return Result.success(list);
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
    @PostMapping("findAllRole")
    @ApiOperation("查询所有角色")
    public List<Role> findAllRole()
    {
        return roleService.findAllRole();
    }
    @PostMapping("deleteRole")
    @ApiOperation("删除角色同时删除角色对应的所有权限功能")
    public void deleteRole(Role role)
    {
      roleService.deleteRole(role);
      roleService.deleteRoleFunctionByRoleId(role.getId());
    }
    @PostMapping("insertRole")
    @ApiOperation("新增角色")
    public void insertRole(Role role)
    {
        roleService.insertRole(role);
    }
}
