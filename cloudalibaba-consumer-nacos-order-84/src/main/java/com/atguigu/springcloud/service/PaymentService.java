package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.atguigu.springcloud.service.impl.PaymentFallbackService;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
//@Component
public interface PaymentService
{
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
    
}
