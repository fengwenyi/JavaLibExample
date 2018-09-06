package com.fengwenyi.messageengine;

import com.fengwenyi.javalib.handler.HandlerRegister;
import com.fengwenyi.messageengine.handler.AliPayHandler;
import com.fengwenyi.messageengine.handler.VXPayHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Bean配置
 *
 * @author Wenyi Feng
 * @since 2018-09-06
 */
@Configuration
public class BeanConfig {

    @Autowired
    private AliPayHandler aliPayHandler;

    @Autowired
    private VXPayHandler vxPayHandler;

    @Bean
    public HandlerRegister messageEngineBean() {

        HandlerRegister handlerRegister = new HandlerRegister();

        handlerRegister.setHandler("ali", aliPayHandler);
        handlerRegister.setHandler("vx", vxPayHandler);

        return handlerRegister;
    }

}
