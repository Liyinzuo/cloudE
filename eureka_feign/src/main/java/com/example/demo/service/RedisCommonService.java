package com.example.demo.service;

import com.example.demo.service.error.EurekaCommonHystrix;
import com.obs.services.model.ObjectListing;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "eureka-common", fallback = EurekaCommonHystrix.class)
public interface RedisCommonService {

    @PostMapping(value = "/saveRedis")
    public String saveRedis (@RequestParam(name = "key") String key, @RequestParam(name = "value") String value);

    @PostMapping(value = "/deleteKey")
    public String deleteKey(@RequestParam(name = "key") String key);

    @PostMapping(value = "/getRedis")
    public Object getRedis(@RequestParam(name = "key") String key);

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestPart("file")MultipartFile file, @RequestParam(name = "buckName") String buckName, @RequestParam(name = "objectName") String objectName);

    @PostMapping(value = "/deleteFile")
    public String deleteFile(@RequestParam(name = "buckName")String buckName, @RequestParam(name = "objectName")String objectName);

    @PostMapping(value = "/listFile")
    public ObjectListing listFile(@RequestParam(name = "buckName") String buckName);
}
