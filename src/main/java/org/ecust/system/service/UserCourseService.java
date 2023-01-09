package org.ecust.system.service;

import org.ecust.system.pojo.param.AddUserCourseParam;
import org.ecust.system.pojo.param.DeleteUserCourseParam;
import org.ecust.system.utils.Result;

public interface UserCourseService {
    Result addUserCourse(AddUserCourseParam addUserCourseParam);

    Result getUserCourse(Long userNumber);

    Result getCourseUser(Long courseNo);

    Result deleteUserCourse(DeleteUserCourseParam deleteUserCourseParam);
}
