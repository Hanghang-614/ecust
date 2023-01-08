package org.ecust.system.service;

import org.ecust.system.pojo.param.*;
import org.ecust.system.utils.Result;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    Result login(LoginParam loginParam);

    Result register(MultipartFile file, RegisterParam registerParam);

    Result getAllStudentOrTeacher(UserPageParam pageParam);

    Result updateUser(UpdateUserParam updateUserParam);

    Result deleteUser(Long userId);

    Result getUserById(Long userId);

    Result addUser(RegisterParam registerParam);

    Result upLoadPhoto(MultipartFile file,Long userId);

    Result getUserByUserNumber(Long userNumber);
}
