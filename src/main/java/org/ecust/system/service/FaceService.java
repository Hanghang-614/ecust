package org.ecust.system.service;

import org.ecust.system.utils.Result;
import org.springframework.web.multipart.MultipartFile;

public interface FaceService {
    Result comparePhoto(MultipartFile file, Long userNumber);

    Result comparePhoto2(String image, Long userNumber);
}
