package org.ecust.system.pojo.entity;

import lombok.Data;

@Data
public class User {
    private Long userId;
    private String studentId;
    private String sex;
    private String name;
    private String phone;
    private String email;
    private String identificationId;
    private String birthday;
    private String password;
    private Long roleId;
}
