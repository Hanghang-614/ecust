package org.ecust.system.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Course{
    private Long id;
    @TableField("courseNo")
    private Long courseNo;
    private String name;
    private float credit;
    private Long term;
    @TableField("teacherName")
    private String teacherName;
}
