package com.example.demo.service.impl;

import com.example.demo.service.ClientRedisService;
import org.springframework.stereotype.Component;

@Component
public class ClientRedisServiceImpl implements ClientRedisService {
    @Override
    public Object redisGet(String key) {
        return "client redis value 获取失败 -->";
    }
}
