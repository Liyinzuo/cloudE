package com.example.demo.control;

import com.example.demo.service.EurekaRibbonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RibbonController {

    private static Logger logger = LoggerFactory.getLogger(RibbonController.class);

    @Resource
    private EurekaRibbonService ribbonService;

    private String foo = "ribbon";

    @GetMapping("/ribbonX")
    public String ribbonX() {
        return ribbonService.sayHi();
    }

    @GetMapping("/ribbonE")
    public String ribbonE() {
        return foo;
    }
}
