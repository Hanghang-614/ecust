package org.ecust.system.service;

import org.ecust.system.pojo.entity.User;

import java.util.List;

public interface UserService {
    public User login(String studentId,String password);
    void InsertUser(String studentId,String name,String identificationId,String password);
    void UpdateUser(String sex,String birthday,String phone,String email,String studentId);
    void Keepalive(String studentId);
    void cancel(String studentId);
     List<User> showAllusers();
}
