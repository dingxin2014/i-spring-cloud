package com.meituan.zuul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/index")
    public ResponseEntity index() {
        log.info(">>> Hello World!");
        return ResponseEntity.ok(String.format("[%s] Hello World!", appName));
    }
}
