package com.example.demo.control;

import com.example.demo.service.RedisCommonService;
import com.obs.services.model.ObjectListing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
public class FeignWithFileController {

    private static Logger logger = LoggerFactory.getLogger(FeignWithFileController.class);

    @Resource
    private RedisCommonService redisCommonService;

    @PostMapping(value = "/uploadFile")
    public String uploadFile(@RequestPart("file")MultipartFile file, String buckName, String objectName) {

        logger.info("开始文件上传服务 桶名:{}, 文件名:{}, 文件大小:{}", buckName, objectName, file.getSize());

        String resposeString = redisCommonService.uploadFile(file, buckName, objectName);
        return resposeString;
    }

    @PostMapping(value = "/deleteFile")
    public String deleteFile(String buckName, String objectName) {

        logger.info("开始文件删除服务 桶名:{}, 文件名:{}", buckName, objectName);

        String resposeString = redisCommonService.deleteFile(buckName, objectName);

        if (resposeString.equals("ok")) {
            return "删除成功";
        }
        return "删除失败";
    }

    @PostMapping(value = "/listFile")
    public ObjectListing listFile(String buckName) {

        logger.info("开始文件查询服务 桶名:{}", buckName);

        ObjectListing responseO = redisCommonService.listFile(buckName);
        if (responseO == null) {
            return null;
        }
        return responseO;
    }

}
