package org.ecust.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.ecust.system.mapper.RoleMapper;
import org.ecust.system.mapper.UserMapper;
import org.ecust.system.pojo.entity.Role;
import org.ecust.system.pojo.entity.User;
import org.ecust.system.pojo.param.*;
import org.ecust.system.pojo.vo.UserVo;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
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

    @Override
    public Result getAllStudentOrTeacher(UserPageParam pageParam) {
        Page<User> userPage = new Page<>(pageParam.getPage(),pageParam.getPageSize());
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(pageParam.getRoleId()!=0) {
            userLambdaQueryWrapper.eq(User::getRoleId,pageParam.getRoleId());
        }
        Page<User> page = userMapper.selectPage(userPage, userLambdaQueryWrapper);
        List<User> records = page.getRecords();
        List<UserVo> userVos = transform(records);
        return Result.success(userVos);
    }

    @Override
    public Result updateUser(UpdateUserParam updateUserParam) {
        User user = new User();
        BeanUtils.copyProperties(updateUserParam,user);
        userMapper.updateById(user);
        return Result.success("更新成功");
    }

    @Override
    public Result deleteUser(Long userId) {
        userMapper.deleteById(userId);
        return Result.success("删除成功");
    }

    private List<UserVo> transform(List<User> records) {
        List<UserVo> userVos = new ArrayList<>();
        for(User user : records){
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user,userVo);
            Long roleId = user.getRoleId();
            Role role = roleMapper.selectById(roleId);
            userVo.setRoleName(role.getRoleName());
            userVos.add(userVo);
        }
        return userVos;
    }
}
