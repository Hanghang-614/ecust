package org.ecust.system.service.impl;

import com.alibaba.fastjson.JSON;
import org.ecust.system.pojo.param.BaiduResult;
import org.ecust.system.pojo.param.PhotoParam;
import org.ecust.system.service.AuthService;
import org.ecust.system.service.FaceService;
import org.ecust.system.utils.Base64Util;
import org.ecust.system.utils.GsonUtils;
import org.ecust.system.utils.HttpUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FaceServiceImpl implements FaceService {
    public static String faceMatch() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {
            String imgSrc1 = "src/main/resources/static/photo/lyf1.jpg";
            String imgSrc2 = "src/main/resources/static/photo/lyf2.jpg";

            FileInputStream fin1 = new FileInputStream(new File(imgSrc1));
            //可能溢出,简单起见就不考虑太多,如果太大就要另外想办法，比如一次传入固定长度byte[]
            byte[] bytes1  = new byte[fin1.available()];
            //将文件内容写入字节数组，提供测试的case
            fin1.read(bytes1);
            fin1.close();

            FileInputStream fin2 = new FileInputStream(new File(imgSrc2));
            //可能溢出,简单起见就不考虑太多,如果太大就要另外想办法，比如一次传入固定长度byte[]
            byte[] bytes2  = new byte[fin2.available()];
            //将文件内容写入字节数组，提供测试的case
            fin2.read(bytes2);
            fin2.close();


            List<PhotoParam> photoParams = new ArrayList<>();
            PhotoParam photoParam1 = new PhotoParam();
            photoParam1.setImage(Base64Util.encode(bytes1));

            PhotoParam photoParam2 = new PhotoParam();
            photoParam2.setImage(Base64Util.encode(bytes2));

            photoParams.add(photoParam1);
            photoParams.add(photoParam2);

            String param = GsonUtils.toJson(photoParams);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            BaiduResult baiduResult = JSON.parseObject(result, BaiduResult.class);
            float score = baiduResult.getResult().getScore();
            System.out.println(result);
            return "score:"+score;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
