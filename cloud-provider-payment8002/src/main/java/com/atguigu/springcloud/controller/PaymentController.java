package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverport;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("////////插入结果"+result);

        if(result>0){
            return new CommonResult(200,"插入数据库成功,serverport:"+serverport,result);
        }else{
            return new CommonResult(404,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment p = paymentService.getPaymentById(id);
        log.info("////////插入结果"+p);

        if(p!=null){
            return new CommonResult(200,"查询成功，serverport:"+serverport,p);
        }else{
            return new CommonResult(404,"没有信息",null);
        }
    }

}
