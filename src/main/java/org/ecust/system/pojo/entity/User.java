package org.ecust.system.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {
    @TableField("userId")
    private Long userId;
    @TableField("studentId")
    private String studentId;
    private String sex;
    private String name;
    private String phone;
    private String email;
    @TableField("identificationId")
    private String identificationId;
    private String birthday;
    private String password;
    @TableField("roleId")
    private Long roleId;
    private Long status;
}
