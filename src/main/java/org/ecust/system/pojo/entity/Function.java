package org.ecust.system.pojo.entity;

import lombok.Data;

@Data
public class Function {
    private Long id;
    private String functionName;
    private Long parentId;
    private String href;
}
