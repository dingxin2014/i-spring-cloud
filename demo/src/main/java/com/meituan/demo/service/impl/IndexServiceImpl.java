package com.meituan.demo.service.impl;

import com.meituan.demo.service.IndexService;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService{


    RetryTemplate retryTemplate = new RetryTemplate();

    @Override
    @Async
    @Retryable(maxAttempts = 10)
    public void test() {
        System.out.println(">>>>");
    }
}
