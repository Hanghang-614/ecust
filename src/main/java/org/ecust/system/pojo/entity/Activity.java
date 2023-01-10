package org.ecust.system.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Activity{
    private Long id;
    private Date beginTime;
    private Date endTime;
    private Long courseNo;
}
