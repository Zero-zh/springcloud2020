package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverport;

    @GetMapping(value = "/payment/consul")
    public String paymentconsul(){
        return "springcloud with paymentconsul : "+serverport+"\t"+ UUID.randomUUID().toString();
    }

}
