package org.ecust.system.pojo.param;

import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class FaceResult {
    private float score;
    private List<Map<String,String>> face_list;
}
