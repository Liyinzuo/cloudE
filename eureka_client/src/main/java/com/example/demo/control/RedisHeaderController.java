package com.example.demo.control;

import com.example.demo.service.ClientRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisHeaderController {

    private static Logger logger = LoggerFactory.getLogger(RedisHeaderController.class);

    @Autowired
    ClientRedisService clientRedisService;

    @PostMapping(value = "/getRedis")
    public Object getRedis(String key) {

        logger.info("访问redis value开始 --");
        return clientRedisService.redisGet(key);
    }
}
