package com.example.demo.service.error;

import com.example.demo.service.RedisCommonService;
import com.obs.services.model.ObjectListing;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EurekaCommonHystrix implements RedisCommonService {


    @Override
    public String saveRedis(String key, String value) {
        return "feign saveRedis error";
    }

    @Override
    public String deleteKey(String key) {
        return "feign deleteKey error";
    }

    @Override
    public Object getRedis(String key) {
        return "feign getRedis error";
    }

    @Override
    public String uploadFile(MultipartFile file, String buckName, String objectName) {
        return "uploadFile ERROR";
    }

    @Override
    public String deleteFile(String buckName, String objectName) {
        return "deleteFile ERROR";
    }


    @Override
    public ObjectListing listFile(String buckName) {
        return null;
    }
}
