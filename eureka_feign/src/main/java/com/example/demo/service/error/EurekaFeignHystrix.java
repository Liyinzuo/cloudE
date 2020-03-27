package com.example.demo.service.error;

import com.example.demo.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class EurekaFeignHystrix implements FeignService {
    @Override
    public String clientTest() {
        return "feign error --> ";
    }

    @Override
    public Object listUser() {
        return "user test error -->";
    }
}
