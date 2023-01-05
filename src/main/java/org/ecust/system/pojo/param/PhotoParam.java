package org.ecust.system.pojo.param;

import lombok.Data;

@Data
public class PhotoParam {
    private String image;
    private String image_type = "BASE64";
}
