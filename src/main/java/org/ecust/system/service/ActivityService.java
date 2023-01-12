package org.ecust.system.service;

import org.ecust.system.pojo.entity.Activity;
import org.ecust.system.pojo.param.ActivityParam;
import org.ecust.system.utils.Result;

import java.util.Date;
import java.util.List;

public interface ActivityService {
    Long findId(Long id);
    Date findBegin(Long id);
    Date findEnd(Long id);
    List<Activity> findActivityById(Long id);
    Result addActivity(ActivityParam activityParam);
    Result deleteActivity(Long id);
    Result endActivity(Long id);
    Result selectWhoJoin(Long id);
    List<Activity> selectAllActivity();
}
