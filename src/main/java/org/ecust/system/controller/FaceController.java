package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.service.FaceService;
import org.ecust.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("face")
public class FaceController {
    @Autowired
    FaceService faceService;
    @PostMapping("judge")
    @ApiOperation("人脸对比接口，需要一张人脸照片和当前登录用户的学号")
    public Result judgeFace(@RequestParam("image") MultipartFile file,@RequestParam("userNumber") Long userNumber){
        return faceService.comparePhoto(file,userNumber);
    }
}
