package org.ecust.system.service;

import org.ecust.system.pojo.param.PageParam;
import org.ecust.system.pojo.vo.StudentVo;

import java.util.List;

public interface StudentService {
    List<StudentVo> getAllStudent(PageParam param);
}
