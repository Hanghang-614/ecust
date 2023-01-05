package org.ecust.system.pojo.entity;

import lombok.Data;

@Data
public class Student {
    private Long id;
    private Long studentNumber;
    private String name;
    private Long classId;
    private String sex;
}
