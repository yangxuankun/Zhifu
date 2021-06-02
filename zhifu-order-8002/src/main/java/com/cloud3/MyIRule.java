package com.cloud3;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyIRule {
    //变更默认的loadBalancer
    //随机
    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }
}
