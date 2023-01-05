package org.ecust.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ecust.system.mapper.StudentMapper;
import org.ecust.system.pojo.entity.Student;
import org.ecust.system.pojo.param.PageParam;
import org.ecust.system.pojo.vo.StudentVo;
import org.ecust.system.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<StudentVo> getAllStudent(PageParam pageParam) {
        Page<Student> page = new Page<>(pageParam.getPage(), pageParam.getPageSize());
        Page<Student> studentPage = studentMapper.selectPage(page, new LambdaQueryWrapper<>());
        List<Student> records = studentPage.getRecords();
        List<StudentVo> studentVos = transform(records);
        return studentVos;
    }

    private List<StudentVo> transform(List<Student> records) {
        List<StudentVo> studentVos = new ArrayList<StudentVo>();
        for(Student student : records){
            StudentVo studentVo = new StudentVo();
            BeanUtils.copyProperties(student,studentVo);
            studentVos.add(studentVo);
        }
        return studentVos;
    }

}
