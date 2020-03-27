package com.example.demo.service;

import com.example.demo.service.error.EurekaFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "eureka-client", fallback = EurekaFeignHystrix.class)
public interface FeignService {

    @GetMapping(value = "clientTest")
    public String clientTest();

    @PostMapping(value = "/user/listUser")
    public Object listUser();
}
