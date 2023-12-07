package org.ecust.system.service;

import org.ecust.system.pojo.entity.User;

public interface UserService {
    public User login(String studentId,String password);
    void InsertUser(String studentId,String name,String identificationId,String password);
    void UpdateUser(String sex,String birthday,String phone,String email,String studentId);
}
