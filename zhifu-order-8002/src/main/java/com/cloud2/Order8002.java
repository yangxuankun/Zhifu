package com.cloud2;

import com.cloud3.MyIRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-ZHIFU-SERVICE",configuration = MyIRule.class)
public class Order8002 {
    public static void main(String[] args) {
        SpringApplication.run(Order8002.class,args);
    }
}
