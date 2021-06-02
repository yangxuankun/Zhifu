package com.cloud1.controller;

import com.cloud1.PayService.PayMentService;
import com.cloud1.api.entities.CommonResult;
import com.cloud1.api.entities.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "getOpenfeignHystrixFallback")
public class OpenFeignController {
    /*private static final String PAYMENT_URL = "http://CLOUD-ZHIFU-SERVICE";
    @Resource
    private RestTemplate restTemplate;*/
    @Resource
    private PayMentService payMentService;
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info(String.valueOf(payment));
        return payMentService.create(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int id){
        return payMentService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/pay/time")
    public String getOpenFeignTime(){
        return payMentService.getOpenFeignTime();
    }

    @HystrixCommand(fallbackMethod = "getOpenfeignHystrixFallback",
         commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                 value = "8000")})
    @GetMapping(value = "/consumer/pay/timeout")
    public String getOpenfeignTimeOut(){
        return payMentService.getOpenFeignTimeOut();
    }
    public String getOpenfeignHystrixFallback(){
        return "端口号：8008，fallback";
    }
}
