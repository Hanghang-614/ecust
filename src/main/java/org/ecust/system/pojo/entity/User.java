package org.ecust.system.pojo.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private Long userNumber;
    private String name;
    private String password;
    private Long classId;
    private String sex;
    private String photo_url;
    private Long role_id;
}
