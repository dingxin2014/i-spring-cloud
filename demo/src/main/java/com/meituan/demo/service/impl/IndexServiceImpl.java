package com.meituan.demo.service.impl;

import com.meituan.demo.service.IndexService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    RestTemplate restTemplate;

    static final AtomicInteger signal = new AtomicInteger(0);

    static final String PRODUCER_SERVICE_NAME = "demo2-service";

    @Override
    @Async
    @Retryable(maxAttempts = 5)
    public void test() {
        if (signal.addAndGet(1) == 1)
            throw new RuntimeException();
        System.err.println("signal is " + signal.get());
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(String.format("http://%s/feign/{id}", StringUtils.upperCase(PRODUCER_SERVICE_NAME)), String.class, new Random().nextInt());
        System.out.println(String.format(">>>> Current thread is [%s], Response is [%s]", Thread.currentThread().getId(), responseEntity.getBody()));
    }
}
