package org.ecust.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.ecust.system.mapper.UserMapper;
import org.ecust.system.pojo.entity.User;
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
    @GetMapping("/export/student")
    public ResponseEntity<byte[]> downloadExcel() {
        List<User> users = userMapper.selectList(new LambdaQueryWrapper<>());
        byte[] excelFile = ExcelFileExporter.exportUserInfoToExcel(users);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=report.xlsx")
                .body(excelFile);
    }

}
