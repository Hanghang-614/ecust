package org.ecust.system.pojo.vo;

import lombok.Data;

@Data
public class ScoreVo
{
    private Long courseId;
    private String courseName;//课程名称
    private String term;
    private Long grade;
}
