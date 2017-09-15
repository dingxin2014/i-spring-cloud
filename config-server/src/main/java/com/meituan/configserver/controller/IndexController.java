package com.meituan.configserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class IndexController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/index")
    public ResponseEntity index() {
        return ResponseEntity.ok(String.format("[%s][%s] Hello World!", appName, new Date()));
    }
}
