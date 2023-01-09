package org.ecust.system.service;

import org.ecust.system.pojo.entity.Function;
import org.ecust.system.pojo.entity.RoleFunction;

import java.util.List;

public interface RoleService {
    List<Function> findAllFunction(Long parentId);
    List<Function> findAllRoleFunction(Long roleId);
    void deleteRoleFunction(RoleFunction roleFunction);
    void insertRoleFunction(RoleFunction roleFunction);
}
