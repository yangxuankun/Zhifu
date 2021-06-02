package com.cloud1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperMain8005.class,args);
    }
}
