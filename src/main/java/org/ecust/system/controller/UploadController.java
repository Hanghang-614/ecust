package org.ecust.system.controller;


import io.swagger.annotations.ApiOperation;
import org.ecust.system.service.UploadService;
import org.ecust.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
public class UploadController {
    @Autowired
    UploadService uploadService;

    @PostMapping("upLoadPhoto")
    @ApiOperation("添加用户照片")
    public Result addUser(@RequestParam MultipartFile file, @RequestParam("userNumber") Long userNumber){
        return uploadService.upLoadPhoto(file,userNumber);
    }
}
