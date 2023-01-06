package org.ecust.system.pojo.vo;

import lombok.Data;

@Data
public class CourseVo {
    private Long courseNo;
    private String name;
    private float credit;
    private Long term;
    private String teacherName;
}
