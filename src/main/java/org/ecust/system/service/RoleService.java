package org.ecust.system.service;

import org.ecust.system.pojo.entity.Function;
import org.ecust.system.pojo.entity.Role;
import org.ecust.system.pojo.entity.RoleFunction;
import org.ecust.system.pojo.param.FunctionParam;
import org.ecust.system.pojo.param.RoleFunctionParam;
import org.ecust.system.utils.Result;

import java.util.List;

public interface RoleService {
    List<Function> findAllFunction(Long parentId);
    List<FunctionParam> findAllRoleFunction(Long roleId);
    Result deleteRoleFunction(RoleFunctionParam roleFunctionParam);
    Result insertRoleFunction(RoleFunctionParam roleFunctionParam);
    List<Role> findAllRole();
    void deleteRole(Role role);
    void deleteRoleFunctionByRoleId(Long roleId);
    void insertRole(Role role);
}
