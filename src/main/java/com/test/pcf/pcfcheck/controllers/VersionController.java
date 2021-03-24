package com.test.pcf.pcfcheck.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class VersionController {

    @RequestMapping("/jvm")
    public String indexJvm(){
        try {
            InetAddress ip = InetAddress.getLocalHost();
            return ip.toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @RequestMapping("/java")
    public String indexJava(){
        String ret = System.getProperty("java version");
        return ret;
    }
}
