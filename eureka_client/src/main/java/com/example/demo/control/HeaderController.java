package com.example.demo.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HeaderController {

    private static Logger logger = LoggerFactory.getLogger(HeaderController.class);

    @PostMapping(value = "/clientHeaderTest")
    public Object clientHeaderTest(HttpServletRequest request) {

        String auth = request.getHeader("Authorization");
        logger.error("Authorization:{}", auth);
        return auth;
    }
}
