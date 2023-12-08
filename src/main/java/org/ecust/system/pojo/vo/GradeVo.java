package org.ecust.system.pojo.vo;

import lombok.Data;

@Data
public class GradeVo {
    private Long userId;
    private String name;//用户名称
    private Long courseId;
    private String courseName;//课程名称
    private Long grade;//成绩
    private String term;
}
