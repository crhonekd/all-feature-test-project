package com.dave.kafka.spring.beans;

import com.dave.kafka.spring.configuration.GeneralConfiguration;
import com.dave.kafka.spring.configuration.ReceiverConfiguration;
import com.dave.kafka.spring.configuration.SenderConfiguration;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SenderConfiguration.class, ReceiverConfiguration.class,
        GeneralConfiguration.class})
@TestPropertySource("classpath:application.properties")
@Ignore
public class ReceiverTest {

    private static final String HELLOWORLD_TOPIC = "david_test";

    @Autowired
    private KafkaSender sender;

//    SpringKafkaReceiverImpl receiver = new SpringKafkaReceiverImpl(Mockito.mock(ReceiverService.class));
    @Autowired
SpringKafkaReceiverImpl receiver;
//    @ClassRule
//    public static KafkaEmbedded embeddedKafka =
//            new KafkaEmbedded(1, true, HELLOWORLD_TOPIC);


    @Test
    public void testReceive() throws InterruptedException {

        sender.send(HELLOWORLD_TOPIC, "Hello World!");

        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertEquals(receiver.getLatch().getCount(),0);
    }
}
