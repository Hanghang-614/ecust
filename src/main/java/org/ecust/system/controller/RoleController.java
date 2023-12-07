package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.entity.Role;
import org.ecust.system.service.RoleService;
import org.ecust.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping("findAllRole")
    @ApiOperation("查询所有角色信息")
    List<Role> findAllRole(){
        return roleService.findAllRole();
    }
    @PostMapping("deleteRole")
    @ApiOperation("删除角色信息")
    void deleteRole(Role role){
        roleService.deleteRole(role);
    }
    @PostMapping("insertRole")
    @ApiOperation("插入角色信息")
    void insertRole(Role role){
        roleService.insertRole(role);
    }
    @PostMapping("selectBystudentId")
    @ApiOperation("根据用户账号查询角色信息")
    String selectBystudentId(String studentId){ return roleService.selectBystudentId(studentId);}
    @PostMapping("allocRole")
    @ApiOperation("为用户分配角色")
    void allocRole(String studentId,Long roleId){roleService.allocRole(studentId,roleId);}
}
