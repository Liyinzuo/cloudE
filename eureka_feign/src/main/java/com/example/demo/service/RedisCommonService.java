package com.example.demo.service;

import com.example.demo.service.error.EurekaCommonHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-common", fallback = EurekaCommonHystrix.class)
public interface RedisCommonService {

    @PostMapping(value = "/saveRedis")
    public String saveRedis (@RequestParam(name = "key") String key, @RequestParam(name = "value") String value);

    @PostMapping(value = "/deleteKey")
    public String deleteKey(String key);

    @PostMapping(value = "/getRedis")
    public Object getRedis(String key);
}
