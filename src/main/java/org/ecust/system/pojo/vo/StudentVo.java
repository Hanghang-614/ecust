package org.ecust.system.pojo.vo;

import lombok.Data;
/*
Vo用于返回值，需要啥返回啥给前端
 */
@Data
public class StudentVo {
    private Long id;
    private Long studentNum;
    private String name;
    private Long classId;
    private String sex;
}
