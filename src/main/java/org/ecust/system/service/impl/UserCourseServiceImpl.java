package org.ecust.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.ecust.system.mapper.CourseMapper;
import org.ecust.system.mapper.RoleMapper;
import org.ecust.system.mapper.UserCourseMapper;
import org.ecust.system.mapper.UserMapper;
import org.ecust.system.pojo.entity.Course;
import org.ecust.system.pojo.entity.Role;
import org.ecust.system.pojo.entity.User;
import org.ecust.system.pojo.entity.UserCourse;
import org.ecust.system.pojo.param.AddUserCourseParam;
import org.ecust.system.pojo.param.DeleteUserCourseParam;
import org.ecust.system.pojo.vo.UserVo;
import org.ecust.system.service.UserCourseService;
import org.ecust.system.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCourseServiceImpl implements UserCourseService {
    @Autowired
    UserCourseMapper userCourseMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    RoleMapper roleMapper;
    @Override
    public Result addUserCourse(AddUserCourseParam addUserCourseParam) {
        Long courseId = addUserCourseParam.getCourseId();
        Long userId = addUserCourseParam.getUserId();
        UserCourse userCourse = new UserCourse();
        userCourse.setCourseId(courseId);
        userCourse.setUserId(userId);
        userCourseMapper.insert(userCourse);
        return Result.success("选课成功");
    }

    @Override
    public Result getUserCourse(Long userNumber) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUserNumber,userNumber);
        userLambdaQueryWrapper.select(User::getId);
        User user = userMapper.selectOne(userLambdaQueryWrapper);
        if(user == null) return Result.fail(666,"学号输入错误");

        LambdaQueryWrapper<UserCourse> userCourseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userCourseLambdaQueryWrapper.eq(UserCourse::getUserId,user.getId());
        userCourseLambdaQueryWrapper.select(UserCourse::getCourseId);
        List<UserCourse> userCourses = userCourseMapper.selectList(userCourseLambdaQueryWrapper);
        List<Long> courseIds = new ArrayList<>();
        for(UserCourse userCourse : userCourses){
            Long courseId = userCourse.getCourseId();
            courseIds.add(courseId);
        }
        if(courseIds.size()!=0){
            LambdaQueryWrapper<Course> courseLambdaQueryWrapper = new LambdaQueryWrapper<>();
            courseLambdaQueryWrapper.in(Course::getId,courseIds);
            List<Course> courses = courseMapper.selectList(courseLambdaQueryWrapper);
            return Result.success(courses);
        }
        return Result.fail(666,"查找失败");

    }

    @Override
    public Result getCourseUser(Long courseNo) {
        LambdaQueryWrapper<Course> courseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        courseLambdaQueryWrapper.eq(Course::getCourseNo,courseNo).select(Course::getId);
        Course course = courseMapper.selectOne(courseLambdaQueryWrapper);
        if(course!=null && course.getId()!=null){
            LambdaQueryWrapper<UserCourse> userCourseLambdaQueryWrapper = new LambdaQueryWrapper<>();
            userCourseLambdaQueryWrapper.eq(UserCourse::getCourseId,course.getId())
                    .select(UserCourse::getCourseId);
            List<UserCourse> userCourses = userCourseMapper.selectList(userCourseLambdaQueryWrapper);
            List<Long> userIds = new ArrayList<>();
            for(UserCourse userCourse : userCourses){
                userIds.add(userCourse.getId());
            }
            if(userIds.size()!=0){
                LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
                userLambdaQueryWrapper.in(User::getId,userIds);
                List<User> users = userMapper.selectList(userLambdaQueryWrapper);
                List<UserVo> userVos = transform(users);
                return Result.success(userVos);
            }
        }
        return Result.fail(666,"查询失败");
    }

    @Override
    public Result deleteUserCourse(DeleteUserCourseParam deleteUserCourseParam) {
        LambdaQueryWrapper<UserCourse> userCourseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userCourseLambdaQueryWrapper.eq(UserCourse::getCourseId,deleteUserCourseParam.getCourseId());
        userCourseLambdaQueryWrapper.eq(UserCourse::getUserId,deleteUserCourseParam.getUserId());
        userCourseMapper.delete(userCourseLambdaQueryWrapper);
        return Result.success("退课成功");
    }

    private List<UserVo> transform(List<User> records) {
        List<UserVo> userVos = new ArrayList<>();
        for(User user : records){
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user,userVo);
            Long roleId = user.getRoleId();
            Role role = roleMapper.selectById(roleId);
            userVo.setRoleName(role.getRoleName());
            userVos.add(userVo);
        }
        return userVos;
    }
}
