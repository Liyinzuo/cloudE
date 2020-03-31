package com.example.demo.control;

import com.example.demo.util.HuaWeiUtils;
import com.obs.services.model.ObjectListing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUpdateControl {

    private static Logger logger = LoggerFactory.getLogger(FileUpdateControl.class);


    @PostMapping(value = "/uploadFile")
    public String uploadFile(@RequestPart(name = "file") MultipartFile file, @RequestParam(name = "buckName") String buckName, @RequestParam(name = "objectName") String objectName) {

        logger.info("开始文件上传服务 桶名:{}, 文件名:{}, 文件大小:{}", buckName, objectName, file.getSize());
        String url = null;
        try {
            url = HuaWeiUtils.putObject(HuaWeiUtils.initObs(buckName), buckName, objectName, file.getBytes());
        } catch (IOException e) {
            return "error";
        }

        return url;
    }

    @PostMapping(value = "/deleteFile")
    public String uploadFile(String buckName, String objectName) {

        logger.info("开始文件删除服务 桶名:{}, 文件名:{}", buckName, objectName);

        HuaWeiUtils.deleteObject(HuaWeiUtils.initObs(buckName), buckName, objectName);

        return "ok";
    }

    @PostMapping(value = "/listFile")
    public ObjectListing listFile(String buckName) {

        logger.info("开始文件查询服务 桶名:{}", buckName);

        return HuaWeiUtils.listFile(HuaWeiUtils.initObs(buckName), buckName);
    }
}
