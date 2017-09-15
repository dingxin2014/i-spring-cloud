package com.meituan.demo.remote;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "demo2-service")
public interface ProducerFeign {
}
