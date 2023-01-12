package org.ecust.system.service.impl;

import org.ecust.system.mapper.ActivityMapper;
import org.ecust.system.mapper.CourseMapper;
import org.ecust.system.pojo.entity.Activity;
import org.ecust.system.pojo.entity.User;
import org.ecust.system.pojo.param.ActivityParam;
import org.ecust.system.pojo.vo.CourseVo;
import org.ecust.system.service.ActivityService;
import org.ecust.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import  java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    CourseMapper courseMapper;
    @Override
    public Long findId(Long id)
    {
        return activityMapper.findId(id);
    }
    @Override
    public Date findBegin(Long id)
    {
        return activityMapper.findBegin(id);
    }
    @Override
    public Date findEnd(Long id)
    {
        return activityMapper.findEnd(id);
    }
    @Override
    public List<Activity> findActivityById(Long id)
    {
        return activityMapper.findActivityById(id);
    }
    @Override
    public Result addActivity(ActivityParam activityParam)
    {
        Long courseNo=courseMapper.findCourseNo(activityParam.getCourseNo());
        if(courseNo==0)
        {
            return Result.fail(666,"不存在这个课程，发布考勤失败");
        }
        else{
            activityMapper.addActivity(activityParam);
            return Result.success("发布考勤成功");
        }

    }
    @Override
    public Result deleteActivity(Long id)
    {
        activityMapper.deleteActivity(id);
        Long idd=activityMapper.findId(id);
        if(idd!=0)
        return Result.success("删除考勤成功");
        else
            return Result.fail(666,"删除考勤失败");
    }
    @Override
    public Result endActivity(Long id)
    {
        Date begin=activityMapper.findBegin(id);
        Date end=activityMapper.findEnd(id);
        Date date=new Date();
        if(date.compareTo(begin)>0&&date.compareTo(end)<0)
        {
            activityMapper.endActivity(id);
            return Result.success("结束考勤成功");
        }
       else if(date.compareTo(begin)<=0)
           return Result.fail(666,"考勤尚未开始");
       else
           return Result.fail(666,"考勤已经结束");
    }
    @Override
    public Result selectWhoJoin(Long id)
    {
        List<User> list=activityMapper.selectWhoJoin(id);
        return Result.success(list);
    }
}
