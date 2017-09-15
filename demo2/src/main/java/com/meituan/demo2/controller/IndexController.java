package com.meituan.demo2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/feign")
    public ResponseEntity feign() {
        return ResponseEntity.ok(String.format("[%s] Hello World!", appName));
    }
}
