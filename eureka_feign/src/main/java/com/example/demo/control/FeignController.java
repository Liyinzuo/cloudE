package com.example.demo.control;

import com.example.demo.config.RedisConfig;
import com.example.demo.config.SysConfigEntity;
import com.example.demo.service.FeignService;
import com.example.demo.service.RedisCommonService;
import com.example.demo.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {

    private static Logger logger = LoggerFactory.getLogger(FeignController.class);

    @Resource
    FeignService feignService;
    @Resource
    RedisConfig redisConfig;
    @Resource
    RedisUtils redisUtils;
    @Resource
    RedisCommonService redisCommonService;

    @GetMapping("/feignTest")
    public String feignTest() {
        return feignService.clientTest();
    }

    @PostMapping("/listUser")
    public Object listUser() {
        return feignService.listUser();
    }

    @PostMapping(value = "/saveRedis")
    public String saveRedis(String key, String value) {
        logger.error("feign保存开始 --> key:{}, value:{}", key, value);
        redisCommonService.saveRedis(key,value);
        return "success";
    }


}
