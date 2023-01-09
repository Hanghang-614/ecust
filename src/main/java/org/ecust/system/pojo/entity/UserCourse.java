package org.ecust.system.pojo.entity;

import lombok.Data;

@Data
public class UserCourse {
    private Long id;
    private Long userId;
    private Long courseId;
    private Float score;
}
