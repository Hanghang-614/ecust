package org.ecust.system.pojo.param;

import lombok.Data;

@Data
public class BaiduResult {
    private Long error_code;
    private String error_msg;
    private Long id;
    private Long timestamp;
    private int cached;
    private FaceResult result;
}
