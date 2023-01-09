package org.ecust.system.pojo.param;

import lombok.Data;

@Data
public class DeleteUserCourseParam {
    private Long userId;
    private Long courseId;
}
