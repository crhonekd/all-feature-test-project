package com.dave.kafka.spring.beans;

import com.dave.kafka.spring.service.ReceiverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class SpringKafkaReceiverImpl implements KafkaReceiver {

    private ReceiverService receiverService;

    @Autowired
    public SpringKafkaReceiverImpl(ReceiverService receiverService) {
        this.receiverService = receiverService;
    }

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringKafkaReceiverImpl.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @Override
    @KafkaListener(topics = "${kafka.topic.helloworld}")
    public void receive(String payload) throws Exception {
        LOGGER.info("Message received: " + payload);
        latch.countDown();
        receiverService.process(payload);
    }
}
