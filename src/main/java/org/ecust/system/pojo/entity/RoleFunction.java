package org.ecust.system.pojo.entity;

import lombok.Data;

@Data
public class RoleFunction {
  private Long id;
  private Long roleId;//角色id
  private Long functionId;//功能id
}
