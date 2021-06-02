package com.cloud1.service.impl;

import com.cloud1.dao.PayDao;
import com.cloud1.api.entities.Payment;
import com.cloud1.service.PayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayServiceImpl implements PayService {
    @Resource
    private PayDao payDao;
    public int create(Payment payment) {
        return payDao.create(payment);
    }
    public Payment getPaymentById(int id) {
        return payDao.getPaymentById(id);
    }
}
