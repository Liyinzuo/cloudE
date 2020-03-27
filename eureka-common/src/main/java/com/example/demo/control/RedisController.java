package com.example.demo.control;

import com.example.demo.config.RedisConfig;
import com.example.demo.config.SysConfigEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {

    private static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Resource
    private RedisConfig redisConfig;

    @PostMapping("/saveRedis")
    public String saveRedis(String key, String value) {
        logger.error("common接收保存redis开始 --> key:{}, value:{}", key, value);
        SysConfigEntity sysConfigEntity = new SysConfigEntity();
        sysConfigEntity.setParamKey(key);
        sysConfigEntity.setParamValue(value);
        redisConfig.saveOrUpdate(sysConfigEntity);
        return "ok";
    }

    @PostMapping("/deleteKey")
    public String deleteKey(String key) {
        redisConfig.delete(key);
        return "ok";
    }

    @PostMapping("/getRedis")
    public SysConfigEntity getRedis(String key) {
        logger.info("获取redis:{}", key);
        return redisConfig.get(key);
    }
}
