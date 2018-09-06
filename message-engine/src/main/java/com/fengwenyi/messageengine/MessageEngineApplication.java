package com.fengwenyi.messageengine;

import com.fengwenyi.javalib.handler.Handler;
import com.fengwenyi.javalib.handler.HandlerRegister;
import com.fengwenyi.javalib.messageengine.CommonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MessageEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageEngineApplication.class, args);
    }

    @Autowired
    private HandlerRegister handlerRegister;

    @RequestMapping("/pay")
    public void pay(String type, String name, String account) {

        CommonMessage cm = new CommonMessage();
        cm.setHeader(MEConstant.NAME, name);
        cm.setHeader(MEConstant.ACCOUNT, account);

        Handler handler = handlerRegister.getHandler(type);
        try {
            handler.execute(cm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
