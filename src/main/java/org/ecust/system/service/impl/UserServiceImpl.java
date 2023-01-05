package org.ecust.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.ecust.system.mapper.UserMapper;
import org.ecust.system.pojo.entity.User;
import org.ecust.system.pojo.param.LoginParam;
import org.ecust.system.pojo.param.RegisterParam;
import org.ecust.system.service.UserService;
import org.ecust.system.utils.Base64Util;
import org.ecust.system.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Result login(LoginParam loginParam) {
        Long userNumber = loginParam.getUserNumber();
        Long password = loginParam.getPassword();

        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUserNumber,userNumber);
        userLambdaQueryWrapper.eq(User::getPassword,password);
        User user = userMapper.selectOne(userLambdaQueryWrapper);
        if(user==null){
            return Result.fail(666,"用户不存在或者密码错误");
        }
        return Result.success("登陆成功");
    }

    @Override
    public Result register(MultipartFile file, RegisterParam registerParam) {
        Long userNumber = registerParam.getUserNumber();
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUserNumber,userNumber);
        User user = userMapper.selectOne(userLambdaQueryWrapper);
        if(user!=null){
            return Result.fail(666,"该用户已存在");
        }
        User userCreate = new User();
        BeanUtils.copyProperties(registerParam,userCreate);
        String originalFilename = file.getOriginalFilename();
        String fileName = registerParam.getUserNumber()+ "." + StringUtils.substringAfterLast(originalFilename, ".");
        String filePath = "src/main/resources/static/photo/"+fileName;
        userCreate.setPhotoUrl(filePath);
        try {
            byte[] content = file.getBytes();
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(content);
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        userMapper.insert(userCreate);
        return Result.success("注册成功");
    }
}
