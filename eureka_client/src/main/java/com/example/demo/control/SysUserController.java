package com.example.demo.control;


import com.example.demo.model.SysUser;
import com.example.demo.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author Lyz
 * @since 2020-03-25
 */

@RestController
@RequestMapping(value = "/user")
public class SysUserController {

    private static Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Resource
    SysUserService sysUserService;
    @Value("${server.port}")
    String port;

    @PostMapping(value = "/listUser")
    public Object listUser() {
        logger.info("访问端口为{}服务", port);
        List<SysUser> users = sysUserService.list();
        return users;
    }

}

