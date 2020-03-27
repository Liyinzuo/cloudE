package com.example.demo.service;

import com.example.demo.service.impl.ClientRedisServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-common", fallback = ClientRedisServiceImpl.class)
public interface ClientRedisService {

    @PostMapping(value = "/getRedis")
    public Object redisGet(@RequestParam(name = "key") String key);
}
