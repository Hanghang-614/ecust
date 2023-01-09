package org.ecust.system.service;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.ecust.system.mapper.UserMapper;
import org.ecust.system.pojo.entity.User;
import org.ecust.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class UploadService {
    @Autowired
    UserMapper userMapper;

    private String bucket = "ecust-wch";
    private String endpoint = "oss-cn-shanghai.aliyuncs.com";
    private String accessKeyId = "LTAI5t8Aptam9E9voK6gG9rg";
    private String accessKeySecret = "WVWwxBNcQu3GE0u5X1eUAbG3XYAt4v";
    public Result upLoadPhoto(MultipartFile file, Long userNumber) {
        String originalFilename = file.getOriginalFilename();
        String fileName = userNumber + "." + StringUtils.substringAfterLast(originalFilename, ".");
        String objectName = "userPhoto" +"/"+fileName;
        try {
            // 填写Byte数组。
            byte[] content = file.getBytes();
            // 创建PutObject请求。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            ossClient.putObject(bucket, objectName, new ByteArrayInputStream(content));
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } catch (IOException exception){
            exception.printStackTrace();
        }
        String host = "https://" + bucket + "." + endpoint+"/"+objectName;
        User user = new User();
        user.setPhotoUrl(host);
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUserNumber,userNumber);
        userMapper.update(user,userLambdaQueryWrapper);
        return Result.success(host);
    }
}
