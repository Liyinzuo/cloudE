package com.example.demo.control;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ClientController {

    @Resource
    DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String port;


    @GetMapping("clientTest")
    public String clientTest() {
        String info = "service port --> " + port;
        return info;
    }
}
