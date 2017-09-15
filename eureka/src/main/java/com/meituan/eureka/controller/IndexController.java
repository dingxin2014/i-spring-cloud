package com.meituan.eureka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Slf4j
public class IndexController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping(value = {"/index"})
    public ResponseEntity index() {
        log.info(">>> hello world");
        return ResponseEntity.ok(String.format("[%s] Hello World!", appName));
    }
}
