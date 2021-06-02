package com.cloud1.PayService.Impl;

import com.cloud1.PayService.PayMentService;
import com.cloud1.api.entities.CommonResult;
import com.cloud1.api.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PayMentImpl implements PayMentService {

    @Override
    public CommonResult create(Payment payment) {
        return null;
    }

    @Override
    public CommonResult getPaymentById(int id) {
        return null;
    }

    @Override
    public String getOpenFeignTime() {
        return null;
    }

    @Override
    public String getOpenFeignTimeOut() {
        return "这里是getOpenFeignTimeOut，无法连接服务";
    }

    @Override
    public String getOpenFeignTime2() {
        return "这里是getOpenFeignTime2，无法连接服务";
    }
}
