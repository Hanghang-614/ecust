package org.ecust.system.pojo.param;

import lombok.Data;

@Data
public class UserPageParam {
    private int page = 1;
    private int pageSize =10;
    private Long roleId;
}
