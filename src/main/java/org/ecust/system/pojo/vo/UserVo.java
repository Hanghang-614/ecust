package org.ecust.system.pojo.vo;

import lombok.Data;

@Data
public class UserVo {
    private Long id;
    private Long userNumber;
    private String name;
    private Long classId;
    private String sex;
    private String photoUrl;
    private String roleName;
}
