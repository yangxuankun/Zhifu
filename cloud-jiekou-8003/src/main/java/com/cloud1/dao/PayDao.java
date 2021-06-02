package com.cloud1.dao;

import com.cloud1.api.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayDao {
    /*添加一个新的数据，返回数字判定成功与否*/
    public int create(Payment payment);
    /*根据ID查询某一数据并返回*/
    public Payment getPaymentById(@Param("id") int id);
}
