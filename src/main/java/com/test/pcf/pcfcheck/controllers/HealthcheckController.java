package com.test.pcf.pcfcheck.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {

    @RequestMapping("/healthcheck")
    public String indexJava() { return "Health Check Successful";}
}
