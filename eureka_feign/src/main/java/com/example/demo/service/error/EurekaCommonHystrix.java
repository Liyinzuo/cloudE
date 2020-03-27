package com.example.demo.service.error;

import com.example.demo.service.RedisCommonService;
import org.springframework.stereotype.Component;

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
}
