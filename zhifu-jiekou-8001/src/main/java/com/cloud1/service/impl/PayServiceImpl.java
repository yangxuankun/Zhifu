package com.cloud1.service.impl;

import cn.hutool.core.util.IdUtil;
import com.cloud1.dao.PayDao;
import com.cloud1.api.entities.Payment;
import com.cloud1.service.PayService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
//@DefaultProperties(defaultFallback = "getFallback")
public class PayServiceImpl implements PayService {
    @Resource
    private PayDao payDao;
    public int create(Payment payment) {
        return payDao.create(payment);
    }
    public Payment getPaymentById(int id) {
        return payDao.getPaymentById(id);
    }
    public String getPaymentTime() {
        return "线程池:" + Thread.currentThread().getName() + "----方法名：getPaymentTime";
    }
    //服务降级
    @HystrixCommand(fallbackMethod = "getFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
            value = "6000")
    })
    public String getPaymentTimeOut() {
        //int i = 10/0;
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "----方法名：getPaymentTimeOut";
    }
    public String getFallback() {
        return "线程池:" + Thread.currentThread().getName() + "----方法名：getFallback";
    }


    //服务熔断
    @HystrixCommand(fallbackMethod = "getCircuitBreakerError",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "4"),//请求访问总数
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "4000"),//采集判断所需信息的时间（滚动时间窗）
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")//错误百分比，判断：超出一半则打开熔断
    })
    public String getCircuitBreaker(int i){
         if (i < 0) {
             throw new RuntimeException("--此处是if，发生错误--");
         }
         return "调用成功,唯一流水号：" + IdUtil.simpleUUID();
    }

    public String getCircuitBreakerError(int i){
        return "访问错误，开启熔断,id:" + i;
    }
}
