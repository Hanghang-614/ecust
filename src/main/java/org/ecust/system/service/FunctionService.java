package org.ecust.system.service;

import org.ecust.system.pojo.entity.Function;

import java.util.List;

public interface FunctionService {
   List<Function> selectByParentId(Long parentId);
   List<Function> selectByRoleId(Long roleId);

}
