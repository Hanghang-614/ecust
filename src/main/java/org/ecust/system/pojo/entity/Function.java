package org.ecust.system.pojo.entity;

import lombok.Data;

@Data
public class Function
{
    private Long functionId;//功能id
    private String functionName;//功能名称
    private String functionUrl;//功能的url地址
    private Long parentId;//父级功能id
}
