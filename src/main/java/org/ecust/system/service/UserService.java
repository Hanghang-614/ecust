package org.ecust.system.service;

import org.ecust.system.pojo.param.LoginParam;
import org.ecust.system.pojo.param.RegisterParam;
import org.ecust.system.utils.Result;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    Result login(LoginParam loginParam);

    Result register(MultipartFile file, RegisterParam registerParam);
}
