package org.ecust.system.pojo.param;

import lombok.Data;

@Data
public class FunctionParam {
    private Long id;
    private String functionName;
    private Long parentId;
}
