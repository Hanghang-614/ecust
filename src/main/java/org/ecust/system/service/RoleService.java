package org.ecust.system.service;

import org.ecust.system.pojo.entity.Function;
import org.ecust.system.pojo.entity.Role;
import org.ecust.system.pojo.entity.RoleFunction;

import java.util.List;

public interface RoleService {
    List<Function> findAllFunction(Long parentId);
    List<Function> findAllRoleFunction(Long roleId);
    void deleteRoleFunction(RoleFunction roleFunction);
    void insertRoleFunction(RoleFunction roleFunction);
    List<Role> findAllRole();
    void deleteRole(Role role);
    void deleteRoleFunctionByRoleId(Long roleId);
    void insertRole(Role role);
}