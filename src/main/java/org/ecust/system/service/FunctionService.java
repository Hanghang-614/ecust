package org.ecust.system.service;

import org.ecust.system.pojo.entity.Function;
import org.ecust.system.pojo.entity.RoleFunction;

import java.util.List;

public interface FunctionService {
   List<Function> selectByParentId(Long parentId);
   List<Function> selectByRoleId(Long roleId);
   void deleteRoleFunction(Long roleId,Long functionId);
   void insertRoleFunction(Long roleId,Long functionId);
   void insertManyRoleFunctions(List<RoleFunction> userInfos);

}
