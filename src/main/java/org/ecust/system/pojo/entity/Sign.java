package org.ecust.system.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;


@Data
public class Sign {
    private Long id;
    private Long courseNo;
    private Long userNumber;
    @TableField("isCheck")
    private int isCheck; // 0-签到失败 1-签到成功
    private Date time;
}
