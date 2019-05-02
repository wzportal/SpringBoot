package com.wzportal.app.jms.impl;

import com.wzportal.app.jms.JmsService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.jms.Destination;

@Service
public class JmsServiceImpl implements JmsService {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Override
    public void sendMsg(String msg) {
        //空白直接返回，不向消息队列发送
        if (StringUtils.isEmpty(msg)) {
            return;
        }
        // 定义消息队列，名称与消费方约定一致
        Destination destination = new ActiveMQQueue("myQueue");
        jmsTemplate.convertAndSend(destination, msg);
    }
}
