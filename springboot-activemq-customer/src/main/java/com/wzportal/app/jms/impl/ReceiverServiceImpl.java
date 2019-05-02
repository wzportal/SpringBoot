package com.wzportal.app.jms.impl;

import com.wzportal.app.jms.ReceiverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiverServiceImpl implements ReceiverService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverServiceImpl.class);

    @JmsListener(destination = "myQueue")
    public void processMessage(String content) {
        LOGGER.info("消费MSG:" + content);
    }
}
