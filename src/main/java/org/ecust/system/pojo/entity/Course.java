package org.ecust.system.pojo.entity;

import lombok.Data;

@Data
public class Course
{
    private Long courseId;
    private String courseName;
    private String classroom;
    private float credit;
    private Long hour;
    private String term;
}
