package org.ecust.system.pojo.entity;

import lombok.Data;

@Data
public class Course{
    private Long id;
    private Long courseNo;
    private String name;
    private float credit;
    private Long term;
    private String teacherName;
}
