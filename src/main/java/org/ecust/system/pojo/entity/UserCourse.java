package org.ecust.system.pojo.entity;


import lombok.Data;


@Data
public class UserCourse
{
    private Long id;
    private Long courseId;
    private Long userId;
    private String term;
    private Long grade;
}
