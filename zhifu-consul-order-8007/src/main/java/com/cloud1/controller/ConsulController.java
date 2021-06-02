package com.cloud1.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsulController {
    private static final String CONSUL_URL = "http://zhifu-consul-jiekou-8006";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping(value = "/con/pay/consul")
    public String getServerPort(){
        return restTemplate.getForObject(CONSUL_URL + "/pay/consul",String.class);
    }
}
