package org.ecust.system.service;

import org.springframework.web.multipart.MultipartFile;

public interface FaceService {
    Boolean comparePhoto(MultipartFile file,Long userNumber);
}
