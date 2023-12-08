package org.ecust.system.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.ecust.system.pojo.entity.User;

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
            throw new RuntimeException("失败创建Excel文件", e);
        }
    }
    public static byte[] exportUserCourseInfoToExcel(List<User> data) {
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
            throw new RuntimeException("失败创建Excel文件", e);
        }
    }
    public static byte[] exportUserGradeInfoToExcel(List<User> data) {
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
            throw new RuntimeException("失败创建Excel文件", e);
        }
    }
}
