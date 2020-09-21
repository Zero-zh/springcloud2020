package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class SendMessageController {
    
    @Resource
    private IMessageProvider messageProvider;


//    public SendMessageController(IMessageProvider messageProvider) {
//        this.messageProvider = messageProvider;
//    }

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
