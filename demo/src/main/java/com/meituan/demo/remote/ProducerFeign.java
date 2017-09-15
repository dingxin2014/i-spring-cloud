package com.meituan.demo.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "demo2-service")
public interface ProducerFeign {

    @RequestMapping(value = "/feign/{id}", method = RequestMethod.GET)
    ResponseEntity<String> feign(@PathVariable("id") Integer id);

}
