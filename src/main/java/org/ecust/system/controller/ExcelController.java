package org.ecust.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.ApiOperation;
import org.ecust.system.mapper.CourseMapper;
import org.ecust.system.mapper.UserMapper;
import org.ecust.system.pojo.entity.User;
import org.ecust.system.pojo.vo.CourseVo;
import org.ecust.system.pojo.vo.GradeVo;
import org.ecust.system.service.UserService;
import org.ecust.system.utils.ExcelFileExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("excel")
public class ExcelController {
    //
    @Autowired
    UserMapper userMapper;
    @Autowired
    CourseMapper courseMapper;

    @GetMapping("/export/student")
    @ApiOperation("学生信息报表导出")
    public ResponseEntity<byte[]> downloadstudentExcel() {
        List<User> users = userMapper.selectList(new LambdaQueryWrapper<>());
        byte[] excelFile = ExcelFileExporter.exportUserInfoToExcel(users);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=report.xlsx")
                .body(excelFile);
    }

    @GetMapping("/export/userCourse")
    @ApiOperation("选课信息报表导出")
    public ResponseEntity<byte[]> downloadcourseExcel(String studentId,String term) {
        List<CourseVo> userCourses = courseMapper.findCourse(studentId, term);
        byte[] excelFile = ExcelFileExporter.exportUserCourseInfoToExcel(userCourses);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=report.xlsx")
                .body(excelFile);
    }

    @GetMapping("/export/userGrade")
    @ApiOperation("成绩信息报表导出")
    public ResponseEntity<byte[]> downloadgradeExcel(String studentId,String term) {

        List<GradeVo> Scores = courseMapper.checkScoreByterm(studentId, term);
        byte[] excelFile = ExcelFileExporter.exportUserGradeInfoToExcel(Scores);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=report.xlsx")
                .body(excelFile);
    }

}
