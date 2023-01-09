package org.ecust.system.pojo.param;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class AddSignParam {
    private Long courseNo;
    private Long userNumber;
    private Boolean isCheck;
}
