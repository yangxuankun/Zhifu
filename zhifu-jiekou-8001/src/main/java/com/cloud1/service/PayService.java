package com.cloud1.service;

import com.cloud1.api.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PayService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") int id);
    public String getPaymentTime();
    public String getPaymentTimeOut();
    public String getFallback();
    public String getCircuitBreaker(@Param("i") int i);

}
