package org.ecust.system.service.impl;

import org.ecust.system.mapper.SignMapper;
import org.ecust.system.pojo.entity.Sign;
import org.ecust.system.pojo.param.AddSignParam;
import org.ecust.system.service.SignService;
import org.ecust.system.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    SignMapper signMapper;
    @Override
    public Result addSign(AddSignParam addSignParam) {
        Sign sign = new Sign();
        BeanUtils.copyProperties(addSignParam,sign);
        sign.setTime(new Date());
        signMapper.insert(sign);
        return Result.success("签到成功");
    }
}
