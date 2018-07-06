import com.dave.kafka.spring.beans.*;
import com.dave.kafka.spring.beans.request.CreateUserDataRequest;
import com.dave.kafka.spring.beans.request.DataRequest;
import com.dave.kafka.spring.configuration.GeneralConfiguration;
import com.dave.kafka.spring.configuration.ReceiverConfiguration;
import com.dave.kafka.spring.configuration.SenderConfiguration;
import com.dave.kafka.spring.model.Address;
import com.dave.kafka.spring.model.Name;
import com.dave.kafka.spring.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SenderConfiguration.class, ReceiverConfiguration.class,
        GeneralConfiguration.class})
@TestPropertySource("classpath:application.properties")
@Ignore
public class SpringKafkaApplicationTest {

    private static final String HELLOWORLD_TOPIC = "david_test";


    @Autowired
    private SpringKafkaReceiverImpl receiver;

    @Autowired
    private KafkaSender sender;

    @Test
    public void testReceive() throws Exception {
        sender.send(HELLOWORLD_TOPIC, "Hello Spring Kafka from Testing!");

        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertEquals(receiver.getLatch().getCount(),0);
    }

    @Test
    public void testSendPerson() throws Exception {

        Address address = new Address("Prague", "18600");
        Name name = new Name("John", "Smith");
        Person person = new Person(address, name, 40);

        sender.sendPerson(HELLOWORLD_TOPIC, person);
    }

    @Test
    public void testSendPersonRequest() throws Exception {

        Address address = new Address("Prague", "18600");
        Name name = new Name("John", "Smith");
        Person person = new Person(address, name, 40);

        DataRequest request = new CreateUserDataRequest(person);

        sender.sendRequest(HELLOWORLD_TOPIC, request);
    }

    @Test
    public void testReceivePerson() {
    }


}
