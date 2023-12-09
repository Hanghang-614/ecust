package org.ecust.system.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.ecust.system.pojo.entity.User;
import org.ecust.system.pojo.vo.CourseVo;
import org.ecust.system.pojo.vo.GradeVo;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class ExcelFileExporter {
    public static byte[] exportUserInfoToExcel(List<User> data) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // 创建表头
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("id");
            headerRow.createCell(1).setCellValue("学号");
            headerRow.createCell(2).setCellValue("性别");
            headerRow.createCell(3).setCellValue("姓名");
            headerRow.createCell(4).setCellValue("手机");
            headerRow.createCell(5).setCellValue("邮箱");
            headerRow.createCell(6).setCellValue("身份证");
            headerRow.createCell(7).setCellValue("出生日期");
            headerRow.createCell(8).setCellValue("学籍状态");

            // 更多列...

            // 填充数据
            int rowNum = 1;
            for (User entity : data) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(entity.getUserId());
                row.createCell(1).setCellValue(entity.getStudentId());
                row.createCell(2).setCellValue(entity.getSex());
                row.createCell(3).setCellValue(entity.getName());
                row.createCell(4).setCellValue(entity.getPhone());
                row.createCell(5).setCellValue(entity.getEmail());
                row.createCell(6).setCellValue(entity.getIdentificationId());
                row.createCell(7).setCellValue(entity.getBirthday());
                row.createCell(8).setCellValue(entity.getStatus() == 0 ? "已注销" : "学籍正常");
            }

            workbook.write(out);
            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("创建Excel文件失败", e);
        }
    }


    public static byte[] exportUserCourseInfoToExcel(List<CourseVo> data) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Sheet2");

            // 创建表头
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("用户id");
            headerRow.createCell(1).setCellValue("姓名");
            headerRow.createCell(2).setCellValue("课程号");
            headerRow.createCell(3).setCellValue("课程名");
            headerRow.createCell(4).setCellValue("学期");
            // 更多列...

            // 填充数据
            int rowNum = 1;
            for (CourseVo entity : data) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(entity.getUserId());
                row.createCell(1).setCellValue(entity.getName());
                row.createCell(2).setCellValue(entity.getCourseId());
                row.createCell(3).setCellValue(entity.getCourseName());
                row.createCell(4).setCellValue(entity.getTerm());
            }
            workbook.write(out);
            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("创建Excel文件失败", e);
        }
    }

    public static byte[] exportUserGradeInfoToExcel(List<GradeVo> data) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Sheet3");

            // 创建表头
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("user_id");
            headerRow.createCell(1).setCellValue("姓名");
            headerRow.createCell(2).setCellValue("课程号");
            headerRow.createCell(3).setCellValue("课程名");
            headerRow.createCell(4).setCellValue("成绩");
            headerRow.createCell(5).setCellValue("学期");

            // 更多列...

            // 填充数据
            int rowNum = 1;
            for (GradeVo entity : data) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(entity.getUserId());
                row.createCell(1).setCellValue(entity.getName());
                row.createCell(2).setCellValue(entity.getCourseId());
                row.createCell(3).setCellValue(entity.getCourseName());
                row.createCell(4).setCellValue(entity.getGrade()==null ? "成绩未录入":String.valueOf(entity.getGrade()));
                row.createCell(5).setCellValue(entity.getTerm());
            }

            workbook.write(out);
            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("创建Excel文件失败", e);
        }
    }
}
