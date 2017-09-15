package com.meituan.demo.controller;

import com.meituan.demo.remote.ProducerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class IndexController {

    @Value("${spring.application.name}")
    private String appName;
    @Autowired
    private ProducerFeign producerFeign;

    @GetMapping("/index")
    public ResponseEntity index() {
        return ResponseEntity.ok(String.format("[%s] Hello World!", appName));
    }

    @GetMapping("/remote")
    public ResponseEntity remote() {
        return ResponseEntity.ok(String.format("[%s] call remote service! Response is [%s]", appName,
                producerFeign.feign(new Random().nextInt()).getBody()));
    }

}
