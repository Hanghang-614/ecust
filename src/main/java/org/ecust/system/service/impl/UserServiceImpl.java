package org.ecust.system.service.impl;

import org.ecust.system.mapper.RoleMapper;
import org.ecust.system.mapper.UserMapper;
import org.ecust.system.pojo.entity.User;
import org.ecust.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Override
    public User login(String studentId,String password)
    {
        return userMapper.login(studentId,password);
    }
    @Override
    public void InsertUser(String studentId,String name,String identificationId,String password)
    {
        userMapper.insertUser(studentId,name,identificationId,password);
    }
    @Override
    public void UpdateUser(String sex,String birthday,String phone,String email,String studentId)
    {
        userMapper.UpdateUser(sex,birthday,phone,email,studentId);
    }
    @Override
    public void Keepalive(String studentId){ userMapper.Keepalive(studentId);}
    @Override
    public void cancel(String studentId){ userMapper.cancel(studentId);}
    @Override
    public List<User> showAllusers(){return userMapper.showAllusers();}
}
