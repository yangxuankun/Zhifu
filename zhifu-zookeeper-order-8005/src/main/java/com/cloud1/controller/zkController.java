package com.cloud1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class zkController {
    private static final String ZKJIEKOU8004 = "http://cloud-zhifu-zookeeper-8004";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping(value = "/consumer/payment/zk")
    public String getZkjiekou8005(){
        return restTemplate.getForObject(ZKJIEKOU8004 + "/payment/zk",String.class);
    }
}
