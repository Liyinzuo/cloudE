package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class EurekaRibbonService {

    @Resource
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "sayHiError")
    public String sayHi() {
        return restTemplate.getForObject("http://eureka-client/clientTest", String.class);
    }

    public String sayHiError() {
        return "ribbon error --> ";
    }
}
