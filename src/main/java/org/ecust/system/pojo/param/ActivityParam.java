package org.ecust.system.pojo.param;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityParam {
    private Date beginTime;
    private Date endTime;
    private Long courseNo;
}
