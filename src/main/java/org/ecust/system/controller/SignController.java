package org.ecust.system.controller;

import io.swagger.annotations.ApiOperation;
import org.ecust.system.pojo.param.AddSignParam;
import org.ecust.system.service.SignService;
import org.ecust.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sign")
public class SignController {
    @Autowired
    SignService signService;
    @ApiOperation("添加签到记录")
    @PostMapping("addSign")
    public Result addSign(@RequestBody AddSignParam addSignParam){
        return signService.addSign(addSignParam);
    }
}
