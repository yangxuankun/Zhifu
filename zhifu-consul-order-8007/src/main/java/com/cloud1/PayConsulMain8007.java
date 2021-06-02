package com.cloud1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PayConsulMain8007 {
    public static void main(String[] args) {
        SpringApplication.run(PayConsulMain8007.class,args);
    }
}
