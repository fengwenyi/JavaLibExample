package com.fengwenyi.messageengine.handler;

import com.fengwenyi.javalib.handler.Handler;
import com.fengwenyi.javalib.messageengine.CommonMessage;
import com.fengwenyi.messageengine.MEConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 微信支付handler
 *
 * @author Wenyi Feng
 * @since 2018-09-06
 */
@Component
@Slf4j
public class VXPayHandler implements Handler {
    @Override
    public void execute(CommonMessage message) throws Exception {
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        log.info("支付方式：{}", "微信");
        log.info("姓名：{}", message.getHeader(MEConstant.NAME));
        log.info("账号：{}", message.getHeader(MEConstant.ACCOUNT));

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
