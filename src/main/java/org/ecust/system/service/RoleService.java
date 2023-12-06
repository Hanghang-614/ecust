package org.ecust.system.service;

import org.ecust.system.pojo.entity.Role;
import org.ecust.system.utils.Result;

import java.util.List;

public interface RoleService
{
    List<Role> findAllRole();
    void deleteRole(Role role);
    void insertRole(Role role);
    String selectBystudentId(String studentId);

}
