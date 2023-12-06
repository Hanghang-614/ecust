package org.ecust.system.service;

import org.ecust.system.pojo.entity.User;

public interface UserService {
    public User login(String studentId,String password);
}
