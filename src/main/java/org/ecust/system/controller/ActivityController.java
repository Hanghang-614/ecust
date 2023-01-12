package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.entity.Activity;
import org.ecust.system.pojo.param.ActivityParam;
import org.ecust.system.service.ActivityService;
import org.ecust.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @PostMapping("findActivityById")
    @ApiOperation(value="根据id查询已经发布的活动/考勤")
    public Result findActivityById(Long id)
    {
        List<Activity> list=activityService.findActivityById(id);
        return Result.success(list);
    }
   @PostMapping("addActivity")
   @ApiOperation("发布考勤（向activity表中添加记录)")
   public Result addActivity(@RequestBody ActivityParam activityParam)
   {
       return activityService.addActivity(activityParam);
   }
   @PostMapping("deleteActivity")
   @ApiOperation("删除考勤活动")
   public Result deleteActivity(Long id)
   {
       return activityService.deleteActivity(id);
   }
   @PostMapping("endActivity")
   @ApiOperation("结束考勤")
   public Result endActivity(Long id)
   {
       return activityService.endActivity(id);
   }
   @PostMapping("selectWhoJoin")
   @ApiOperation("根据考勤活动id查询签到人员")
   public Result selectWhoJoin(Long id)
   {
       return activityService.selectWhoJoin(id);
   }
   @PostMapping("selectAllActivity")
   @ApiOperation("查询所有考勤活动")
   public Result selectAllActivity()
   {
       List<Activity> list=activityService.selectAllActivity();
       return Result.success(list);
   }
}
